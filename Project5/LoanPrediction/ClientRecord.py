class ClientRecord:

    def __init__(self, balance, loan_details):
        self.loan_details = ""
        self.balance = balance

    def set_loan_details(self, loan_details):
        self.loan_details = loan_details
