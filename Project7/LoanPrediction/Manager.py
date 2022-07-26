from abc import ABC
from Singleton import Singleton


@Singleton
class Manager(ABC):
    command = None

    def __init__(self):
        pass

    def set_command(self, command):
        self.command = command
