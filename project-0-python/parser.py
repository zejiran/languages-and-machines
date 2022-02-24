# -*- coding: utf-8 -*-
"""
Parser module

@author: zejiran
"""


robot_commands: list = ['move', 'turn', 'face', 'put',
                        'pick', 'move-dir', 'run-dirs', 'move-face']
flow_commands: list = ['defvar', '=', 'skip',
                       'if', 'loop', 'repeat', 'defun']


class Variable:
    def __init__(self, name, value):
        self.name:  str = name
        self.value: str = value

    def modify_name(self, n: str):
        self.name = n

    def modify_value(self, v: str):
        self.value = v


def is_int(s: str) -> bool:
    try:
        int(s)
        return True
    except ValueError:
        return False


def is_variable(value: str, program_variables: list) -> bool:
    for v in program_variables:
        if v.name == value:
            return True
    return False


def is_robot_command(value: str) -> bool:
    """ 
    Check if command is on robot commands group
    """
    for v in robot_commands:
        if v == value:
            return True
    return False


def parse(program: str) -> bool:
    """
    Returns a bool indicating if the program is valid on the robot syntax.
    """
    # Ignore spaces, newlines, and tabulators.
    commands = program.split()

    # Temporal values for manage verification.
    parenthesis_count = 0
    program_variables: list[Variable] = []
    program_functions: list[str] = {'': []}
    new_function: str = ''
    uncounted_params = 0
    is_defining = False
    variable_named = False
    new_variable = Variable('', '')
    robot_command_started = False
    is_moving = False
    is_turning = False
    is_facing = False
    # 0: not started, 1: picking or putting, 2: Ballons or Chips, 3: Number or Variable.
    is_picking_or_putting = 0
    # 0: not started, 1: move-dir, 2: Number or Variable, 3: Direction.
    is_moving_dir = 0
    is_running_dirs = False
    # 0: not started, 1: move-face, 2: Number or Variable, 3: Orientation.
    is_moving_face = 0
    is_assigning = False
    conditional_started = False
    # 0: not started, 1: facing-p, 2: can-put-p, 3: can-pick-p, 4: can-move-p, not cond.
    bool_expression_case = 0
    is_repeat_iteration = False
    # 0: defun, 1: name, 2: params, 3: Block.
    is_defining_function = 0

    for c in commands:
        stop_iteration = False
        # Check if that parenthesis are balanced.
        if (parenthesis_count < 0):
            return False

        while '(' in c:
            parenthesis_count += 1
            c = c.replace('(', '', 1)

        while ')' in c:
            parenthesis_count -= 1
            c = c.replace(')', '', 1)
            if is_defining_function == 2:
                is_defining_function = 3
                program_functions[new_function].append(c.replace(')', ''))
                stop_iteration = True
        if stop_iteration == True:
            continue

        if len(c) == 0:
            continue

        # Validate function definition.
        if c == flow_commands[6]:
            is_defining_function = 1
            continue

        if is_defining_function == 1:
            new_function = c
            program_functions[new_function] = []
            is_defining_function = 2
            continue

        if is_defining_function == 2:
            program_functions[new_function].append(c)
            continue

        if is_defining_function == 3:
            is_defining_function = 0
            if c == "facing-p":
                bool_expression_case = 1
                continue
            if c == "can-put-p":
                bool_expression_case = 2
                continue
            if c == "can-pick-p":
                bool_expression_case = 3
                continue
            if c == "can-move-p":
                bool_expression_case = 4
                continue
            if c == 'not':
                bool_expression_case = 5
                continue
            if is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                continue

        # RepeatTimes command.
        if c == flow_commands[5]:
            is_repeat_iteration = True
            continue

        if is_repeat_iteration:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                is_repeat_iteration = False
                continue
            else:
                return False

        # Repeat command.
        if c == flow_commands[4]:
            conditional_started = True
            continue

        # Verify conditionals.
        if bool_expression_case == 5:  # Recursive special case.
            conditional_started = True

        if conditional_started:
            conditional_started = False
            if c == "facing-p":
                bool_expression_case = 1
                continue
            if c == "can-put-p":
                bool_expression_case = 2
                continue
            if c == "can-pick-p":
                bool_expression_case = 3
                continue
            if c == "can-move-p":
                bool_expression_case = 4
                continue
            if c == 'not':
                bool_expression_case = 5
                continue
            if is_variable(c, program_variables) or c in program_functions[new_function]:
                bool_expression_case = 0
                continue
            if c in program_functions:
                bool_expression_case = 0
                # Calling function {c}.
                new_function = c
                for param in program_functions[c]:
                    if param:
                        uncounted_params += 1
                continue
            else:
                return False

        if bool_expression_case == 1:
            if c == ":north" or c == ":south" or c == ":east" or c == ":west":
                bool_expression_case = 0
                continue
            else:
                return False

        if bool_expression_case == 2:
            if c == "balloons" or c == "chips":
                bool_expression_case = 2.5  # Intermediary state.
                continue
            else:
                return False
        elif bool_expression_case == 2.5:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                bool_expression_case = 0
                continue
            else:
                return False

        if bool_expression_case == 3:
            if c == "balloons" or c == "chips":
                bool_expression_case = 3.5  # Intermediary state.
                continue
            else:
                return False
        elif bool_expression_case == 3.5:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                bool_expression_case = 0
                continue
            else:
                return False

        if bool_expression_case == 4:
            if c == ":north" or c == ":south" or c == ":east" or c == ":west":
                bool_expression_case = 0
                continue
            else:
                return False

        # Introduction of if statement.
        if c == flow_commands[3]:
            conditional_started = True
            continue

        # Assign a value to variable.
        if is_assigning:
            if variable_named:
                if is_int(c):
                    for x in program_variables:
                        if x.name == new_variable.name:
                            x.modify_value(c)
                            variable_named = False
                            is_assigning = False
                            break
                    continue
                else:
                    return False
            for x in program_variables:
                if x.name == c:
                    new_variable.modify_name(c)
                    x.modify_name(c)
                    variable_named = True
                    break
            continue

        if c == flow_commands[1]:
            is_assigning = True
            continue

        # Usage of previous defined functions.
        if c in program_functions:
            # Calling function {c}.
            new_function = c
            for param in program_functions[c]:
                if param:
                    uncounted_params += 1
            continue

        if uncounted_params > 0:
            uncounted_params -= 1
            continue

        # Definition of a variable.
        if is_defining:
            if variable_named:
                if is_int(c):
                    new_variable.modify_value(c)
                    program_variables.append(
                        Variable(new_variable.name, new_variable.value))
                    variable_named = False
                    is_defining = False
                    continue
                else:
                    return False
            variable_name = c
            new_variable.modify_name(variable_name)
            variable_named = True
            continue

        if c == flow_commands[0]:
            is_defining = True
            continue

        # Commands that can be executed on the robot.
        if is_moving:
            is_moving = False
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                continue
            else:
                return False

        if is_turning:
            is_turning = False
            if c == ":left" or c == ":right" or c == ":around":
                continue
            else:
                return False

        if is_facing:
            is_facing = False
            if c == ":north" or c == ":south" or c == ":east" or c == ":west":
                continue
            else:
                return False

        if is_picking_or_putting == 1:
            if c == "Balloons" or c == "Chips":
                is_picking_or_putting = 2
                continue
            else:
                return False
        elif is_picking_or_putting == 2:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                is_picking_or_putting = 0
                continue
            else:
                return False

        if is_moving_dir == 1:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                is_moving_dir = 2
                continue
            else:
                return False
        elif is_moving_dir == 2:
            if c == ":front" or c == ":back" or c == ":left" or c == ":right":
                is_moving_dir = 0
                continue
            else:
                return False

        if is_running_dirs:
            if c == ":front" or c == ":back" or c == ":left" or c == ":right":
                running_was_direction = True
                continue
            elif running_was_direction:
                is_running_dirs = False
            else:
                return False

        if is_moving_face == 1:
            if is_int(c) or is_variable(c, program_variables) or c in program_functions or c in program_functions[new_function]:
                is_moving_face = 2
                continue
            else:
                return False
        elif is_moving_face == 2:
            if c == ":north" or c == ":south" or c == ":east" or c == ":west":
                is_moving_face = 0
                continue
            else:
                return False

        # Verify if the command is a new robot command.
        robot_command_started = is_robot_command(c)
        if robot_command_started:
            if c == robot_commands[0]:
                is_moving = True
            if c == robot_commands[1]:
                is_turning = True
            if c == robot_commands[2]:
                is_facing = True
            if c == robot_commands[3] or c == robot_commands[4]:
                is_picking_or_putting = 1
            if c == robot_commands[5]:
                is_moving_dir = 1
            if c == robot_commands[6]:
                is_running_dirs = True
            if c == robot_commands[7]:
                is_moving_face = 1
            continue

        # Skip command.
        if c == flow_commands[2]:
            continue

        # A command doesn't satisfy the rules.
        return False

    # All commands satisfy the rules.
    return True
