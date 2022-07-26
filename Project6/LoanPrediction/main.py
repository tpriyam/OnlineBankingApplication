from Client import Client
from ClientFactory import ClientFactory
from Manager import Manager
import database
import asyncio
from time import sleep


async def serve() -> None:
    await database.connect_db()

    manager = Manager.instance()
    print(Manager.instance() == manager)
    sleep(1)

    async def query():
        from database import db_loan_prediction
        # await db_loan_prediction.status(db_loan_prediction.text('drop table client'))
        # await db_loan_prediction.status(db_loan_prediction.text('create TABLE client '
        #                                                         '(bank_id INT PRIMARY KEY, name VARCHAR, loan_id INT, '
        #                                                         'username VARCHAR, password VARCHAR);'))
        # await db_loan_prediction.status(db_loan_prediction.text('insert into client values (10001, \'Manan\', 0, '
        #                                                         '\'manankh\', \'qwerty\');'))
        # await db_loan_prediction.status(db_loan_prediction.text('insert into client values (10002, \'Tavishi\', 0, '
        #                                                         '\'tavishi\', \'asdfgh\');'))
        # await db_loan_prediction.status(db_loan_prediction.text('insert into client values (10003, \'Sundar\', 0, '
        #                                                         '\'sundar\', \'zxcvbn\');'))
        # client0 = await ClientFactory.create_client("Manan", "manankh", "qwerty")
        # client2 = await ClientFactory.create_client("Tavishi", "tavishi", "asdfgh")
        # client3 = await ClientFactory.create_client("Sundar", "sndr", "zxcvbn")

        from ClientModel import ClientModel
        name_list = await ClientModel.query.gino.all()
        for entry in name_list:
            print(entry)

    await query()

    # client1 = await ClientFactory.create_client("Tava", "tpr", "poe67")
    # print(client1)


if __name__ == '__main__':
    asyncio.run(serve())
