package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
)

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

// Parse returns a bool indicating if the program is valid on the robot syntax.
func Parse(string) bool {
	//RobotCommands := [...]string{"MOVE", "RIGHT", "LEFT", "ROTATE", "LOOK", "DROP", "FREE", "PICK", "POP", "CHECK", "BLOCKEDP", "NOP"}
	//FlowCommands := [...]string{"BLOCK", "REPEAT", "IF", "DEFINE", "TO", "OUTPUT", "END"}

	return true
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
