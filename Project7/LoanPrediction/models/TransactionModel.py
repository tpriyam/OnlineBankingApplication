from database import db_loan_prediction as db


class TransactionModel(db.Model):
    __tablename__ = 'transactions'

    transaction_id = db.Column(db.Integer(), primary_key=True)
    client_id = db.Column(db.Integer())
    amount_paid = db.Column(db.String())

    def __str__(self):
        return str(self.transaction_id) + " " + str(self.client_id) + " " + str(self.amount_paid)
