from abc import ABC, abstractmethod


class Observer(ABC):
    """
    The Observer interface declares the update method, used by subjects.
    """

    @abstractmethod
    def notify(self) -> None:
        """
        Receive update from subject.
        """
        pass

    @abstractmethod
    def add_client(self, client) -> None:
        pass

    @abstractmethod
    def remove_client(self, client) -> None:
        pass
