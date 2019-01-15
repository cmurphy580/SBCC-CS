'''
@authors: Conor Murphy & Kyle Miller
@description: Simple Flask Hello App
'''

from flask import (Flask, jsonify)
import random
import json

app = Flask(__name__)

with open("greetings.json", "r") as greetings:
    g_list = json.load(greetings)
    #print(g_list)

@app.route("/")
def hello():
    return jsonify(random.choice(g_list['greetings']))

@app.route("/sayhi<string:name>")
def greeting_with_name(name):
    return jsonify(random.choice(g_list['greetings']) + " " + name)
