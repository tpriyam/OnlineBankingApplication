from abc import ABC, abstractmethod


class Observer(ABC):
    """
    The Observer interface declares the update method, used by subjects.
    """

    @abstractmethod
    def update(self) -> None:
        """
        Receive update from subject.
        """
        from Client import Client
        client = Client()
        pass
