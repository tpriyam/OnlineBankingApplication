from abc import ABC
from Command import Command


class DisburseLoanAmount(Command, ABC):

    def execute(self):
        print("Executing Disburse Amount")
