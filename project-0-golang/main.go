package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
	"unicode"
)

var robotCommands = [...]string{"MOVE", "RIGHT", "LEFT", "ROTATE", "LOOK", "DROP", "FREE", "PICK", "POP", "CHECK", "BLOCKEDP"}
var flowCommands = [...]string{"BLOCK", "REPEAT", "IF", "DEFINE", "TO", "OUTPUT", "END"}

// ReadSamples reads all the data of each file placed on the sample folder.
func ReadSamples() []string {
	root := "./samples"
	var files []string

	// Get file names in samples
	err := filepath.Walk(root, func(path string, info os.FileInfo, err error) error {
		files = append(files, path)
		return nil
	})
	if err != nil {
		fmt.Println(err)
	}

	// Get data from each sample
	var filesData []string
	for _, file := range files[1:] {
		fmt.Println("Reading", file, "commands")
		data, err := ioutil.ReadFile(file)
		if err != nil {
			fmt.Println(err)
		}

		filesData = append(filesData, string(data))
	}

	return filesData
}

type variable struct {
	name  string
	value string
}

func (v *variable) ModifyName(n string) {
	v.name = n
}

func (v *variable) ModifyValue(value string) {
	v.value = value
}

// Parse returns a bool indicating if the program is valid on the robot syntax.
func Parse(program string) bool {
	// Ignore spaces, newlines, and tabulators.
	commands := strings.Fields(program)

	// Temporal values for manage verification.
	var programVariables []variable
	isBlockOrIteration := false
	isRobotCommand := false
	isValidCommandParam := false
	isChecking := 0 // CHECK command has three phases 1 CHECK, 2 [C|B], 3 n.
	isLooking := false
	isIteration := false
	timesGiven := false
	iterationStarted := false
	isConditional := false
	boolExpresion := false
	conditionalStarted := false
	isDefining := false
	variableNamed := false
	newVariable := variable{
		name:  "",
		value: "",
	}
	isDefiningFunction := 0 // 0 TO, 1 name, 2 :, 3 param, 4 OUTPUT, 5 commands, 6 END

	for _, c := range commands {
		if isDefiningFunction == 1 {
			isDefiningFunction = 2
			continue
		}

		if isDefiningFunction == 2 {
			if c == ":" {
				isDefiningFunction = 3
				continue
			} else {
				return false
			}
		}

		if isDefiningFunction == 3 {
			isDefiningFunction = 4
			continue
		}

		if isDefiningFunction == 4 {
			if c == "OUTPUT" {
				isDefiningFunction = 5
				continue
			} else {
				return false
			}
		}

		if isDefiningFunction == 5 {
			isDefiningFunction = 6
			continue
		}

		if isDefiningFunction == 6 {
			if c == "END" {
				isDefiningFunction = 0
				continue
			} else {
				return false
			}
		}

		if isDefining {
			if variableNamed {
				if IsInt(c) {
					newVariable.ModifyValue(c)
					programVariables = append(programVariables, newVariable)
					variableNamed = false
					isDefining = false
					continue
				}
			}

			variableName := strings.ToLower(c)
			newVariable.ModifyName(variableName)
			variableNamed = true
			continue
		}

		if boolExpresion {
			if c == "[" {
				boolExpresion = false
				conditionalStarted = true
				continue
			} else {
				return false
			}
		}

		if isConditional {
			isConditional = false
			if c == "true" || c == "True" || c == "1" || c == "false" || c == "False" || c == "0" || c == "BLOCKEDP" {
				boolExpresion = true
				continue
			} else {
				return false
			}
		}

		if c == "]" {
			if iterationStarted || conditionalStarted {
				// Reset variables.
				iterationStarted = false
				conditionalStarted = false
				continue
			} else {
				return false
			}
		}

		if timesGiven {
			if c == "[" {
				timesGiven = false
				iterationStarted = true
				continue
			} else {
				return false
			}
		}

		if isIteration {
			if IsInt(c) {
				timesGiven = true
				isIteration = false
				continue
			} else {
				return false
			}
		}

		if isLooking {
			isLooking = false
			if c == "N" || c == "E" || c == "W" || c == "S" {
				continue
			} else {
				return false
			}
		}

		if isChecking == 1 {
			if c == "C" || c == "B" {
				isChecking = 2
				continue
			} else {
				return false
			}
		}

		if isChecking == 2 {
			isValidCommandParam = IsInt(c) || IsVariable(c, programVariables)
			if isValidCommandParam {
				isValidCommandParam = false
				isChecking = 3
				continue
			} else {
				return false
			}
		}

		if isChecking == 3 {
			isChecking = 0 // Reset check.
			continue
		}

		if c == "NOP" || c == "BLOCKEDP" {
			continue
		}

		if isRobotCommand {
			isValidCommandParam = IsInt(c) || IsVariable(c, programVariables)
			if isValidCommandParam {
				isValidCommandParam = false
				continue
			}

			isRobotCommand = false
			continue
		}

		if c == "IF" {
			isConditional = true
			continue
		}

		if c == "DEFINE" {
			isDefining = true
			continue
		}

		if c == "TO" {
			isDefiningFunction = 1
			continue
		}

		isRobotCommand = IsRobotCommand(c)
		if isRobotCommand {
			if c == "CHECK" {
				isChecking = 1
			}
			if c == "LOOK" {
				isLooking = true
			}
			continue
		}

		if c == ")" {
			if isBlockOrIteration {
				isBlockOrIteration = false // Reset variable.
				continue
			} else {
				return false
			}
		}

		if isBlockOrIteration {
			// BLOCK flow.
			if c == flowCommands[0] {
				continue
			}

			// REPEAT flow.
			if c == flowCommands[1] {
				isIteration = true
				continue
			}

			continue
		}

		if c == "(" {
			// If starts with parenthesis that means it should follow a block or an iteration.
			isBlockOrIteration = true
			continue
		}

		// A command doesn't satisfy the rules.
		return false
	}

	// All commands satisfy the rules.
	return true
}

func IsInt(s string) bool {
	for _, c := range s {
		if !unicode.IsDigit(c) {
			return false
		}
	}

	return true
}

func IsVariable(value string, programVariables []variable) bool {
	for _, v := range programVariables {
		if v.name == value {
			return true
		}
	}
	return false
}

// IsRobotCommand checks if word is on group
func IsRobotCommand(value string) bool {
	for _, v := range robotCommands {
		if v == value {
			return true
		}
	}

	return false
}

func main() {
	filesData := ReadSamples()
	for i, program := range filesData {
		fmt.Println("\n-------------------")
		fmt.Println("Input", i)
		fmt.Println(program)

		validation := Parse(program)

		fmt.Println("\nIs Input", i, "using a correct syntax?")
		if validation {
			fmt.Println("--> YES")
		} else {
			fmt.Println("NO")
		}
	}
}
