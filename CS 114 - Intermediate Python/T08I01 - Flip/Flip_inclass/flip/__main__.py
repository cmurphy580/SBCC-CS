'''
Created on Oct 23, 2018

@author: Raphael Zaafrani & Conor Murphy
'''

import sys
import os
import argparse
from random import choice

# Add the path of the current directory to the sys path so we can import other local modules.
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

# Program version information. Must be manually synched with GIT (boo!).
__version_info__ = ('1', '0', '0')
__version__ = '.'.join(__version_info__)


def main():
    '''Flip a coin'''
    parser = argparse.ArgumentParser(prog="flip")
    parser.add_argument("-c", "--capitalize", help="capitalizes the output.",
                        action='store_true', default=False)
    parser.add_argument('-V', '--version', action='version', version=f"{__version__}")
    args = parser.parse_args()
    s = choice(["head", "tails"]) if not args.capitalize else choice(["head", "tails"]).upper()
    print(f'{s}')

    return 0


if __name__ == '__main__':
    sys.exit(main())
