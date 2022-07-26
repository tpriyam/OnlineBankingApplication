import asyncio
import time
from flask import Flask, request, redirect, url_for
from flask_cors import CORS
import pickle
from sqlalchemy import and_

import database
from Bank import Bank
from ClientFactory import ClientFactory
from Manager import Manager
from SendPaymentReminder import SendPaymentReminder

from threading import Thread
from flask import Flask, jsonify


app = Flask(__name__)
CORS(app)

bank = Bank()
client_factory = ClientFactory(bank)
thread = None

send_payment_reminder = SendPaymentReminder(bank)
manager: Manager = Manager.instance()
manager.set_command(send_payment_reminder)


# async def threaded_task() -> None:
#     print("Starting bank manager command...")
#     duration = 10
#     global manager
#     for i in range(duration):
#         print("Working... {}/{}".format(i + 1, duration))
#         await manager.command.execute()
#         await asyncio.sleep(1)


@app.route('/', methods=['POST', 'GET'])
async def index():
    return redirect("http://localhost:3000/")


@app.route('/manager')
async def manager():
    manager_l = Manager.instance()
    await database.connect_db()
    await manager_l.command.execute()
    await database.disconnect_db()
    return {"message": "idk"}


@app.route('/register', methods=['POST', 'GET'])
async def register():
    if request.method == 'POST':
        name = request.form['name']
        username = request.form['username']
        password = request.form['password']
        await database.connect_db()
        client = await client_factory.create_client(name, username, password)
        bank.add_client(client)
        await database.disconnect_db()
        return redirect("http://localhost:3000/login")
    if request.method == 'GET':
        return redirect("http://localhost:3000/register")


@app.route('/login', methods=['POST', 'GET'])
async def login():
    if request.method == 'POST':
        # TODO: login logic
        username = request.json['username']
        password = request.json['password']
        await database.connect_db()
        from models.ClientModel import ClientModel
        client = await ClientModel.query.where(and_(ClientModel.username == username,
                                                    ClientModel.password == password)).gino.first()
        await database.disconnect_db()
        if client:
            return {'message': 'Successfully logged in!', 'logged_in': True, 'client_id': client.bank_id}
        else:
            return {'message': 'Unsuccessful log in!', 'logged_in': False, 'client_id': None}
    if request.method == 'GET':
        return redirect("http://localhost:3000/login")


@app.route('/loanform', methods=['POST'])
async def loan_form():
    gender = int(request.json['gender'])
    married = int(request.json['married'])
    self_employed = int(request.json['selfEmployed'])
    education = int(request.json['education'])
    credit_history = int(request.json['creditHistory'])
    property_area = int(request.json['propertyArea'])

    client_id = int(request.json['clientId'])

    await database.connect_db()
    from database import db_loan_prediction as db
    from models.ClientModel import ClientModel
    client = await ClientModel.query.where(ClientModel.bank_id == client_id).gino.first()
    from LoanFormFactory import LoanFormFactory

    from Predictor import Predictor
    prediction = Predictor.predict([[gender, married, self_employed, education, credit_history, property_area]])
    message = ""
    if prediction == 0:
        print("Loan rejected")
        message = "Loan rejected"
    else:
        print("Loan approved")
        message = "Loan approved"

    loan_term = 0 if (prediction == 0) else int(request.json['loanTerm'])
    print(loan_term)

    client_current = None
    for cl in bank.client_list:
        if cl.bank_id == client.bank_id:
            client_current = cl
            break

    await LoanFormFactory.create_loan_form(gender, married, self_employed, education, credit_history, property_area,
                                           int(request.json['loanAmount']), loan_term, client_current)
    await database.disconnect_db()
    return {'message': message}


@app.route('/clientstatus', methods=['POST'])
async def clientstatus():
    await database.connect_db()
    from models.ClientModel import ClientModel
    from models.LoanFormModel import LoanFormModel
    from models.TransactionModel import TransactionModel
    # client = await ClientModel.query.where(ClientModel.bank_id == 3659022).gino.first()
    print("\n\n")
    print(request.json)
    print("\n\n")
    client = await ClientModel.query.where(ClientModel.bank_id == int(request.json['clientId'])).gino.first()
    loan_details = None
    if client:
        loan_details = await LoanFormModel.query.where(LoanFormModel.loan_id == client.loan_id).gino.first()
        client_dict = {
            'name': client.name,
            'bank_id': client.bank_id,
            'loan_id': client.loan_id
        }
    else:
        print("No client")
    transactions = None
    if loan_details:
        transactions = await TransactionModel.query.where(TransactionModel.client_id == client.bank_id).gino.all()
    else:
        print("No loan details")
        return {'message': 'Loan not applied', 'client_data':
            {'client': client_dict, 'loan_details': None, 'transactions': None}}
    await database.disconnect_db()

    loan_details = {
        'loan_amount': loan_details.loan_amount,
        'loan_term_months': loan_details.loan_term_months,
        'loan_amount_remaining': loan_details.loan_amount_remaining
    }

    if loan_details['loan_term_months'] == 0:
        return {'message': 'Loan rejected', 'client_data':
            {'client': client_dict, 'loan_details': loan_details, 'transactions': None}}

    transaction_json = dict()
    index = 0
    for trans in transactions:
        transaction_json[index] = {
            'transaction_id': trans.transaction_id,
            'client_id': trans.client_id,
            'amount_paid': trans.amount_paid
        }
        index += 1

    client_data = {'client': client_dict, 'loan_details': loan_details, 'transactions': transaction_json}

    print(client_data)

    print("**********************\n\n\n")
    return {'message': 'Success', 'client_data': client_data}


# TODO: Need this in a thread to run periodically

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=81)

