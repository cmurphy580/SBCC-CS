import csv
import string
from collections import Counter
"""
The Cipher class will decrypt text given to as a argument.
It will also establish a key for the encryped text.
"""


class Cipher():
    """
    The key is a string of all uppercase leeters which substitute for A-Z.
    If no key is passed then a string of A-Z is used.
    """
    def __init__(self, key=None):
        self.key = key if key else string.ascii_uppercase

    """Takes a string and decrypts into plaintext."""
    def decrypt(self, ciphertext):
        """
        Opens ciphertext file and converts into a list of substrings.
        """
        with open(ciphertext, 'r') as text:
            decrypt_text = text.read().replace('\n', '')
        text = decrypt_text.split()
        """
        Set result variable to empty string. Iterate through the text
        and the key to find and words in the encrypted text. Once decrypted,
        add the decrypted text to the result.
        """
        result = ''
        for word in text:
            for k in self.key:
                if word == k[1]:
                    result += k[0] + ' '
        return result
