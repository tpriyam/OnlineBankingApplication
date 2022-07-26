from abc import ABC
from Command import Command


class CollectPayment(Command, ABC):

    def execute(self):
        print("Executing Collect Payment")