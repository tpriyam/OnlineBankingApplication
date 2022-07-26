from abc import ABC
from Client import Client
from Observer import Observer
from Singleton import Singleton


@Singleton
class Manager(Observer, ABC):

    def __init__(self):
        pass

    def update(self, client: Client) -> None:
        print("Update client")
