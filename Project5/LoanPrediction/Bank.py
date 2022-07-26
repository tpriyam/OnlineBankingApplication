class Bank:

    def __init__(self, manager):
        self.manager = manager
        self.client_list = set()