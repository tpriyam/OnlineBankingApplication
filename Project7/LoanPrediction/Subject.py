from abc import abstractmethod, ABC
from Observer import Observer


class Subject(ABC):
    """
    The Subject interface declares a set of methods for managing subscribers.
    """

    @abstractmethod
    def update(self) -> None:
        """
        Notify all observers about an event.
        """
        pass
