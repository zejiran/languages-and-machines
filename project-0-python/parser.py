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
    program_variables: list[Variable] = []
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
    is_repeat_iteration = False
    is_loop = False
    times_given = False
    is_conditional = False
    conditional_started = False
    is_defining = False
    variable_named = False
    new_variable = Variable('', '')
    # 0: not started, 1: facing-p, 2: can-put-p, 3: can-pick-p, 4: can-move-p, not cond.
    bool_expression_case = 0
    # 0: defun, 1: name, 2: params, 3: Block.
    is_defining_function = 0
    parenthesis_count = 0

    for c in commands:
        # Check if that parenthesis are balanced.
        if (parenthesis_count < 0):
            return False

        while '(' in c:
            parenthesis_count += 1
            c = c.replace('(', '', 1)

        while ')' in c:
            parenthesis_count -= 1
            c = c.replace(')', '', 1)

        ##
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
                continue
            else:
                return False

        if is_conditional:
            is_conditional = False
            if c == "facing-p" or c == "can-put-p" or c == "can-pick-p" or c == "can-move-p" or c == 'not':
                bool_expression_case = True
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

        if c == "if":
            is_conditional = True
            continue

        if c == "defvar":
            is_defining = True
            continue

        # Commands that can be executed on the robot.
        if is_moving:
            is_moving = False
            if is_int(c) or is_variable(c, program_variables):
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
            if is_int(c) or is_variable(c, program_variables):
                is_picking_or_putting = 0
                continue
            else:
                return False

        if is_moving_dir == 1:
            if is_int(c) or is_variable(c, program_variables):
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
                is_running_dirs = False
                continue
            else:
                return False

        if is_moving_face == 1:
            if is_int(c) or is_variable(c, program_variables):
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

        # Start of loop command.
        if c == flow_commands[5]:
            is_loop = True
            continue

        # Start of repeat command.
        if c == flow_commands[6]:
            is_repeat_iteration = True
            continue

        # Skip command.
        if c == flow_commands[2]:
            continue

        # A command doesn't satisfy the rules.
        return False

    # All commands satisfy the rules.
    return True
