'''
Created on Nov 19, 2018

@author: Conor Murphy
'''
import json
from flask import (render_template, request, flash, redirect)
from app import app
from app.forms import LoginForm
"""
The root route is the login page.
The user will have to login in first in order
to get their specific playlist.
"""


@app.route('/', methods=['GET', 'POST'])
def login():
    # Get users.json data.
    with open('users.json', 'r+') as jsonfile:
        users_data = json.loads(jsonfile.read())
    # Create login form for user
    form = LoginForm()
    user_data, password = None, None
    if form.validate_on_submit():
        flash("Login requested for {form.username.data}")
        try:
            # If valid data is submitted, see if user is in json file
            # If not, catch the KeyError and flash message
            user_data = users_data[form.username.data]
            # get user password
            password = user_data["password"]
            # If user exists and password is valid, redirect to playlist page
            if user_data and password == form.password.data:
                return redirect(f"/user/{user_data['ID']}")
        except KeyError:
            print(f"User does not exist: {user_data}")
            flash("Incorrect Login.")
    return render_template('login.html', title='Splotify', form=form,
                           user_data=user_data, password=password)

"""
Once the user has logged in their id will be attaced the url and 
direct them to the next page where they can modify to the playlist.
"""


@app.route('/user/<int:user_id>', methods=['GET', 'POST'])
def set_playlist(user_id):
    # Get user data from json file.
    with open('users.json', 'r') as jsonfile:
        data = json.loads(jsonfile.read())
        jsonfile.close()
    users_data = list(data.values())
    user_data = [user for user in users_data if user["ID"] == user_id][0]

    # Get song data from json file.
    with open('songs.json', 'r') as jsonfile:
        songs = json.loads(jsonfile.read())
        jsonfile.close()
    # If there is no user playlist, populate with all songs
    if len(user_data["playlist"]) == 0:
        for song in songs:
            user_data["playlist"].append(song)

    # Add songs, Delete songs, Get new order of playlist if entered.
    if request.method == 'POST':
        # print(request.form)
        # get song user want to remove from input tag.
        remove_song = int(request.form["remove_song"])
        # get song user want to add from input tag.
        add_song = int(request.form["add_song"])
        if type(remove_song) == int and remove_song != 0:
            # remove specific song.
            user_data["playlist"] = list(filter(lambda v:
                                                v["id"] != remove_song,
                                                user_data["playlist"]))
            print("removed!")
        elif type(add_song) == int and add_song != 0:
            # add specific song.
            for song in songs:
                if song["id"] == add_song:
                    user_data["playlist"].append(song)
                    print("appended!")
                    break
        else:
            # extract request from form.
            sort_request = []
            for i in range(len(user_data["playlist"])):
                sort_request.append(request.form[f"{i}"])  
            # filter out and organize changes to the playlist order.
            order_changes = [(i, int(sort_request[i]))
                             for i in range(len(sort_request))
                             if sort_request[i] != "sort"]
            order_changes = tuple(order_changes)
            # make changes to the playlist
            for curr, new in order_changes:
                tune = user_data["playlist"].pop(curr)
                user_data["playlist"].insert(new, tune)
            print('sorted!')

    # Save all changes to users playlist and write all data to json file.
    with open('users.json', 'w') as jsonfile:
        jsonfile.write(json.dumps(data))
        jsonfile.close()

    print(user_data['playlist'])
    return render_template('playlist.html', title='Your Splotify Playlist',
                           user_data=user_data, songs=songs,
                           playlist=user_data["playlist"])
