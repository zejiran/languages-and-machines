# -*- coding: utf-8 -*-
"""
Parser module

@author: zejiran
"""

robot_commands: list = ['move', 'turn', 'face', 'put',
                        'pick', 'move-dir', 'run-dirs', 'move-face']
flow_commands: list = ['defvar', '=', 'skip',
                       'if', 'loop', 'repeat', 'defun', '']


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


def check_robot_command(value: str) -> bool:
    """ 
    Check if command is on group
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
    program_variables: list[Variable] = []
    is_robot_command = False
    is_block_or_iteration = False
    is_valid_command_param = False
    is_turning = False
    is_facing = False
    is_iteration = False
    times_given = False
    iteration_started = False
    is_conditional = False
    bool_expression = False
    conditional_started = False
    is_defining = False
    variable_named = False
    new_variable = Variable('', '')

    # 0 defun, 1 name, 2 `(`, 3 params, 4 `)`, 5 Block, 6 `)`
    is_defining_function = 0

    for c in commands:
        print(f'\nCommand: {c}')

        if is_defining_function == 1:
            is_defining_function = 2
            continue

        if is_defining_function == 2:
            if c == ":":
                is_defining_function = 3
                continue
            else:
                return False

        if is_defining_function == 3:
            is_defining_function = 4
            continue

        if is_defining_function == 4:
            if c == "OUTPUT":
                is_defining_function = 5
                continue
            else:
                return False

        if is_defining_function == 5:
            is_defining_function = 6
            continue

        if is_defining_function == 6:
            if c == "END":
                is_defining_function = 0
                continue
            else:
                return False

        if is_defining:
            if variable_named:
                if is_int(c):
                    new_variable.modify_value(c)
                    program_variables.append(new_variable)
                    variable_named = False
                    is_defining = False
                    continue

            variable_name = c.lower()
            new_variable.modify_name(variable_name)
            variable_named = True
            continue

        if bool_expression:
            if c == "[":
                bool_expression = False
                conditional_started = True
                continue
            else:
                return False

        if is_conditional:
            is_conditional = False
            if c == "facing-p" or c == "can-put-p" or c == "can-pick-p" or c == "can-move-p" or c == 'not':

                bool_expression = True
                continue
            else:
                return False

        if c == "]":
            if iteration_started or conditional_started:
                # Reset variables.
                iteration_started = False
                conditional_started = False
                continue
            else:
                return False

        if times_given:
            if c == "[":
                times_given = False
                iteration_started = True
                continue
            else:
                return False

        if is_iteration:
            if is_int(c):
                times_given = True
                is_iteration = False
                continue
            else:
                return False

        if is_looking:
            is_looking = False
            if c == "N" or c == "E" or c == "W" or c == "S":
                continue
            else:
                return False

        if is_checking == 1:
            if c == "C" or c == "B":
                is_checking = 2
                continue
            else:
                return False

        if is_checking == 2:
            is_valid_command_param = is_int(
                c) or is_variable(c, program_variables)
            if is_valid_command_param:
                is_valid_command_param = False
                is_checking = 3
                continue
            else:
                return False

        if is_checking == 3:
            is_checking = 0  # Reset check.
            continue

        if c == "NOP" or c == "BLOCKEDP":
            continue

        if is_robot_command:
            is_valid_command_param = is_int(
                c) or is_variable(c, program_variables)
            if is_valid_command_param:
                is_valid_command_param = False
                continue

            is_robot_command = False
            continue

        if c == "IF":
            is_conditional = True
            continue

        if c == "DEFINE":
            is_defining = True
            continue

        if c == "TO":
            is_defining_function = 1
            continue

        is_robot_command = check_robot_command(c)
        if is_robot_command:
            if c == "CHECK":
                is_checking = 1
            if c == "LOOK":
                is_looking = True
            continue

        if c == ")":
            if is_block_or_iteration:
                is_block_or_iteration = False  # Reset variable.
                continue
            else:
                return False

        if is_block_or_iteration:
            # BLOCK flow.
            if c == flow_commands[0]:
                continue

            # REPEAT flow.
            if c == flow_commands[1]:
                is_iteration = True
                continue

            continue

        # If starts with parenthesis that means it should follow a block or an iteration.
        if c == "(":
            is_block_or_iteration = True
            continue

        # A command doesn't satisfy the rules.
        return False

    # All commands satisfy the rules.
    return True
