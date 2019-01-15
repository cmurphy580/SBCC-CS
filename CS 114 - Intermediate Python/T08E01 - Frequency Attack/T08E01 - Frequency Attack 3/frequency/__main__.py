"""
Created on Nov 1, 2018
@author: Conor Murphy
"""

import sys
from collections import Counter
import os
import argparse
import frequency.cipher
import csv
import string

"""
Add the path of the current directory to
the sys path so we can import other local modules.
"""
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

# Program version information.
__version_info__ = ('1', '0', '0')
__version__ = '.'.join(__version_info__)


def main():
    """
    Decrypt encrypted text using a frequency attack.
    Function will take two arguments a csv file which should be
    the frequency key, and a text file to decrypt.
    """
    parser = argparse.ArgumentParser(prog="frequency")
    parser.add_argument("ciphertext")
    parser.add_argument("-f", "--freq",
                        help="decrypts text using frequency attack")
    parser.add_argument('-v', '--version',
                        action='version',
                        version=f"{__version__}")
    args = parser.parse_args()
    # print(args)
    """
    The main code that parses the command line
    and performs the frequency attack.
    """
    """
    Open the ciphertext file and convert into a single string. Then split on
    whitespaces,and use the Counter object to determine frequencies. Lastly,
    convert the counter object to a tuple sorted by the frequency count.
    """
    with open(args.ciphertext, 'r') as text:
        decrypt_text = text.read().replace('\n', '')
    counter_obj = list(dict(Counter(decrypt_text.split(' '))).items())
    encrypt_f = sorted(counter_obj, key=lambda t: t[1], reverse=True)
    # print(encrypt_f)
    """
    Open the frequency.csv file and iterate through the file to create a tuple.
    """
    with open(args.freq, 'r') as f:
        frequencies = csv.DictReader(f)
        decrypt_f = []
        for f in frequencies:
            decrypt_f.extend([(f['word'], int(f['frequency']))])
    # print(decrypt_f)
    """
    Merge the encrypted frequencies and the decrypted frequencies using the zip
    method, which ultimately will be passed to the Cypher class as a key
    to decrypt the text.
    """
    word_key = list(zip(
                map(lambda v: v[0], decrypt_f), map(lambda v: v[0], encrypt_f)
            ))
    cipher = frequency.cipher.Cipher(word_key)
    # print(cipher.decrypt(args.ciphertext))
    """
    Create object of uppercase alphanumeric characters. 
    The two for loops and iterates to find the encrypted value for that letter.
    """
    letter_key = {x: '' for x in string.ascii_uppercase}
    for d, e in word_key:
        for letter in letter_key:
            if letter in d:
                i = d.index(letter)
                letter_key[letter] = e[i]
    """
    Print out the key and the decrypted text.
    """
    decrypt_alphabet = ""
    for l in letter_key.values():
        decrypt_alphabet += l
    print(string.ascii_uppercase + "\n-------------------------\n" + decrypt_alphabet)
    print("\nCleartext: \n" + cipher.decrypt(args.ciphertext))

    return 0

if __name__ == '__main__':
    sys.exit(main())
