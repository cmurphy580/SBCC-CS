'''
Gets a string from the user and translates select words into emoji.
 
CS 114: Intermediate Python
@author: Conor Murphy
'''

def emojify(s):
    '''
	Substitutes emoji for select words in the input string.
    '''
	emojis = {"smile": 😊, "cool": 😎), "love": 😍, "poop": 💩, "dog": 🐶, "ok": 👍}
    return emojis[s] if emoji[s] else "Emoji does not exist"
 
 
if __name__ == '__main__':
    # Put your code to get the input, call the function, and print the output.
	import sys

	emoji_name = str(input("What emoji do you want? [smile, cool, love, poop, dog, ok]")).strip()
	print(emojify(emoji_name))

	sys.exit(0)