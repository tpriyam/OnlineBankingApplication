from Client import Client
from Manager import Manager
from Observer import Observer


class Bank(Observer):
    client_list: Client = []
    manager = Manager.instance()

    async def notify(self) -> None:
        if self.client_list:
            for client in self.client_list:
                await client.update()
            print("Updated clients")
        else:
            print("No clients to update")

    def add_client(self, client):
        self.client_list.append(client)

    def remove_client(self, client):
        self.client_list.remove(client)
