from abc import ABC
from Command import Command
from Manager import Manager


class SendPaymentReminder(Command, ABC):

    def __init__(self, bank):
        self.bank = bank

    async def execute(self):
        await self.bank.notify()
        print("Executing Payment Reminders")

    def undo(self):
        pass
