import random
from abc import ABC
from LoanPredictionForm import LoanPredictionForm
from Observer import Observer
from Subject import Subject


class Client(Subject, ABC):

    def __init__(self, name):
        self.name = name
        self.bank_id = int(random.random() * 100000000)
        self.loan_id = 0
        self.loanPredictionForm = LoanPredictionForm("male", 10000, 3)

    def set_username(self, username):
        self.username = username

    def set_password(self, password):
        self.password = password

    def attach(self, observer: Observer) -> None:
        pass

    def detach(self, observer: Observer) -> None:
        pass

    def notify(self) -> None:
        pass

    def __str__(self):
        return str(self.bank_id) + " " + str(self.name) + " " + str(self.loan_id) \
               + " " + str(self.username) + " " + str(self.password)
