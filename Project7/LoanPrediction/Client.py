import random
from abc import ABC
from LoanForm import LoanForm
from Observer import Observer
from Subject import Subject


class Client(Subject, ABC):
    __transaction_id = 100000

    def __init__(self, name, username, password):
        self.name = name
        self.username = username
        self.password = password
        self.bank_id = int(random.random() * 100000000)
        self.loan_id = 0
        self.loanPredictionForm = None  # LoanPredictionForm("male", 10000, 3)

    # def set_username(self, username):
    #     pass
    #
    # def set_password(self, password):
    #     pass

    async def update(self) -> None:

        if self.loanPredictionForm is None:
            print("No loan for client: ", self.bank_id)
            return

        emi_amount = self.loanPredictionForm.loan_amount / self.loanPredictionForm.loan_term_months
        print(self.name + " is sending payment to bank of amount " +
              str(emi_amount))
        from models.LoanFormModel import LoanFormModel
        from models.TransactionModel import TransactionModel

        await TransactionModel.create(transaction_id=Client.__transaction_id,
                                      client_id=self.bank_id, amount_paid=emi_amount)
        Client.__transaction_id += 1
        loan_details = await LoanFormModel.query.where(LoanFormModel.loan_id == self.loan_id).gino.first()
        print("Here:" + str(loan_details))
        if loan_details:
            remaining_amount = loan_details.loan_amount_remaining-emi_amount
            await loan_details.update(loan_amount_remaining=remaining_amount).apply()

    def __str__(self):
        return str(self.bank_id) + " " + str(self.name) + " " + str(self.loan_id) \
               + " " + str(self.username) + " " + str(self.password)
