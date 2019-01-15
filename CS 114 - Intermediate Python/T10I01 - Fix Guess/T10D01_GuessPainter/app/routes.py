'''
Created on Nov 5, 2018

@author: dnevins
'''
import json
import random
from flask import (render_template, request)
from app import app


@app.route('/')
def home():
    return render_template('index.html', title='Guess the Painter?')


def check_guess(has_guess, data, painter_guess, paintings):
    '''Tries to match painter, painting to data. True if all match.'''
    if has_guess:
        guess = [{"painter": painter_guess[i], "image": paintings[i]} for i in
                 range(len(painter_guess))]
        guess_check = [x for x in guess if x in data]
    else:
        guess_check = []

    return len(guess_check) == 3


@app.route('/guess')
def guess():
    with open('data.json', 'r') as jsonfile:
        painter_data = json.loads(jsonfile.read())

    painters = [painter['painter'] for painter in painter_data]
    painters.sort()

    # If you have a guess from the user then use that order for your images. You can also
    # restore the guesses (not implemented). Otherwise you create a nice list of painters
    # for display and shuffle the images.
    if request.method == 'GET' and len(request.args) == 4:
        paintings = request.args.get('images', "").strip().split()
        painter_guess = [request.args.get('painter0', ""), request.args.get('painter1', ""),
                         request.args.get('painter2', "")]
    else:
        random.shuffle(painter_data)
        paintings = [painter['image'] for painter in painter_data]
        painter_guess = []

    guess_correctly = check_guess(len(request.args), painter_data, painter_guess, paintings)

    print(painter_guess)

    return render_template('guess.html', title='Home', guess_made=len(request.args),
                           painters=painters, paintings=paintings, painter_guess=painter_guess,
                           guess_correctly=guess_correctly)
