# -*- coding: utf-8 -*-
"""
Simple robot language parser

@author: zejiran
"""

import os
import robot_parser


def read_samples() -> list:
    """
    Reads all the data of each file placed on the sample folder.
    """
    root: str = './samples'
    files_data: list = []

    # Get data from each sample
    for path in os.listdir(root):
        print(f'Reading {path} commands')
        with open(os.path.join(root, path), 'r') as f:
            files_data.append(f.read())

    return files_data


def main():
    files_data = read_samples()
    for i, program in enumerate(files_data):
        print('\n-------------------')
        print(f'Input {i + 1}')
        print('--\n', program, '\n--')

        validation = robot_parser.parse(program)

        print(f'\nIs Input {i + 1} using a correct syntax?')
        if validation:
            print(f"---> YES")
        else:
            print(f"---> NO")


if __name__ == "__main__":
    main()
