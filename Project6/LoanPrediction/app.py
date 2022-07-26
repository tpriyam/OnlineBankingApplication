from flask import Flask, request, redirect, url_for
from flask_cors import CORS

from ClientFactory import ClientFactory

app = Flask(__name__)
CORS(app)


@app.route('/')
def index():
    return {'heading': 'Welcome to the App'}


@app.route('/register', methods=['POST', 'GET'])
def register():
    if request.method == 'POST':
        name = request.form['name']
        username = request.form['username']
        password = request.form['password']
        client = ClientFactory.create_client(name, username, password)
        return redirect("http://localhost:3000/login")


@app.route('/login', methods=['POST', 'GET'])
def login():
    if request.method == 'GET':
        # message = "You are registered %s" % name
        return "You were redirected"


app.run(host='0.0.0.0', port=81)
