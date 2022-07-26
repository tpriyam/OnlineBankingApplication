from Client import Client


class ClientFactory:

    @staticmethod
    async def create_client(name, username, password):
        client = Client(name)
        client.set_username(username)
        client.set_password(password)
        from ClientModel import ClientModel
        await ClientModel.create(bank_id=client.bank_id, name=client.name, username=username, password=password)
        return client
