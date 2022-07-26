from abc import ABC
from Command import Command


class SendPaymentReminder(Command, ABC):

    def execute(self):
        print("Executing Payment Reminders")
