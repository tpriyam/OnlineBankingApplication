from abc import ABC
from Command import Command


class ShowLoanStatus(Command, ABC):

    def execute(self):
        print("Executing Show Loan Status")