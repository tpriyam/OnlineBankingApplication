from Client import Client
from Manager import Manager


class ClientFactory:

    def __init__(self, bank):
        self.bank = bank

    # @staticmethod
    async def create_client(self, name, username, password):
        client = Client(name=name, username=username, password=password)
        from models.ClientModel import ClientModel
        await ClientModel.create(bank_id=client.bank_id, name=client.name, username=username, password=password)
        self.bank.add_client(client)
        return client
