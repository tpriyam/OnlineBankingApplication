from database import db_loan_prediction as db


class ClientModel(db.Model):
    __tablename__ = 'client'

    bank_id = db.Column(db.Integer(), primary_key=True)
    name = db.Column(db.String())
    loan_id = db.Column(db.Integer())
    username = db.Column(db.String())
    password = db.Column(db.String())

    def __str__(self):
        return str(self.bank_id) + " " + str(self.name) + " " + str(self.loan_id) \
               + " " + str(self.username) + " " + str(self.password)