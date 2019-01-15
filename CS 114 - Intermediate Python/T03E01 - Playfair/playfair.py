"""
Created on Sep 11, 2018

 This program implements the Playfair Cipher. The user will input a string and
 a key phrase, key table, input phrase, encrypted phrase, and decrypted phrase
 based off the cipher.

@author: Conor Murphy
"""


def set_key(key):
    """
    Set the key to be used by the cipher.
    """
    key_list = [v for i, v in enumerate(key) if key[:i].count(v) < 1]
    # append letters of alphabet not already in the list
    alphabet = 'ABCDEFGHIKLMNOPQRSTUVWXYZ'
    for v in alphabet:
        if v not in key_list:
            key_list.append(v)
    # print(key_list)
    return key_list


def get_table(key):
    """Returns a string with the key table formatted as a 5 x 5 block."""
    # remove duplicate values
    key_list = set_key(key)
    table = []
    # create 5x5 table
    for i in range(5):
        table.insert(i, [])
    # populate table
    table = [key_list[i:i+5] for i in range(0, 25, 5)]
    return table


def create_digrams(plaintext):
    """creates the digrams for the test to be decrypted"""
    # create list and remove spaces
    plaintext = list(filter(lambda v: v != ' ', list(plaintext)))
    # if letters are of same value and string is 2 characters long
    if len(plaintext) == 2 and plaintext[0] == plaintext[1]:
            plaintext = plaintext[0] + 'X'
    # insert 'X' between letters of the same value when string is greater than 2
    for i in range(len(plaintext)-1):
        if plaintext[i] == plaintext[i+1]:
            plaintext.insert(i+1, 'X')
            continue
    # print(plaintext)
    # Check to see if the string length is odd. If it is add an 'X'.
    if len(plaintext) % 2 == 1:
        plaintext += 'X'
    # iterates through the string and splits into digrams
    digrams = [plaintext[i:i+2] for i in range(0, len(plaintext), 2)]
    # print(digrams)
    return digrams


def get_position(letter, table):
    """function find the postion of the specific letter in the table"""
    x, y = 0, 0
    for i in range(5):
        for j in range(5):
            if table[i][j] == letter:
                x, y = i, j
    return x, y


def encrypt(plaintext, table):
    """Encrypt using the Playfair cipher and return the encrypted plaintext."""
    digrams = create_digrams(plaintext)
    encrypted_text = []
    for digram in digrams:
        x1, y1 = get_position(digram[0], table)
        x2, y2 = get_position(digram[1], table)
        if x1 == x2:
            if y1 == 4:
                y1 = -1
            if y2 == 4:
                y2 = -1
            encrypted_text.append(table[x1][y1+1])
            encrypted_text.append(table[x2][y2+1])
        elif y1 == y2:
            if x1 == 4:
                x1 = -1
            if x2 == 4:
                x2 = -1
            encrypted_text.append(table[x1+1][y1])
            encrypted_text.append(table[x2+1][y2])
        else:
            encrypted_text.append(table[x1][y2])
            encrypted_text.append(table[x2][y1])
    return ''.join(encrypted_text)


def decrypt(ciphertext, table):
    """
    Decrypt using the Playfair cipher and return the plaintext.
    Uses a simlar approach to the encrypt function.
    """
    digrams = [ciphertext[i:i+2] for i in range(0, len(ciphertext), 2)]
    # print(digrams)
    decrypted_text = []
    for digram in digrams:
        x1, y1 = get_position(digram[0], table)
        x2, y2 = get_position(digram[1], table)
        if x1 == x2:
            if y1 == 4:
                y1 = -1
            if y2 == 4:
                y2 = -1
            decrypted_text.append(table[x1][y1-1])
            decrypted_text.append(table[x2][y2-1])
        elif y1 == y2:
            if x1 == 4:
                x1 = -1
            if x2 == 4:
                x2 = -1
            decrypted_text.append(table[x1-1][y1])
            decrypted_text.append(table[x2-1][y2])
        else:
            decrypted_text.append(table[x1][y2])
            decrypted_text.append(table[x2][y1])
    decrypted_text = list(filter(lambda v: v != 'X', decrypted_text))
    # print(decrypted_text[len(decrypted_text)-1])
    return ' '.join(decrypted_text)

if __name__ == '__main__':
    import sys

    choice = str(input("Encrypt or Decrypt: ")).strip().lower()
    # print(choice)
    if choice == "encrypt":
        # if choice is encrypt enter the keyphrase and message to be encrypted.
        keyphrase = str(input("Please enter a keyphrase: ")).upper()
        message = str(input("Please enter a message: ")).upper()
        if len(keyphrase) > 1 and len(message) > 1:
            table = get_table(keyphrase)
            print(encrypt(message, table))
        else:
            raise RuntimeError("Be sure to enter a valid key and message. Only alphanumeric characters.")
    elif choice == "decrypt":
        # if choice is decrypt enter the keyphrase and encrypted text.
        keyphrase = str(input("Please enter a keyphrase: ")).upper()
        message = str(input("Please enter the encrypted text: ")).upper()
        if len(keyphrase) > 1 and len(message) > 1:
            table = get_table(keyphrase)
            print(decrypt(message, table))
        else:
            raise RuntimeError("Be sure to enter a valid key and message. Only alphanumeric characters.")
    else:
        raise ValueError("You did not enter a valid choice.")

    sys.exit(0)
