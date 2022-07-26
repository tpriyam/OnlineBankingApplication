"""Module that manages database connection."""
from gino import Gino, create_engine

# from config import DBConstants

# pylint: disable=invalid-name
# Connect to the database
db_loan_prediction = None


async def connect_db():
    import ssl
    db_product = 'postgresql://postgres:password@localhost:5432/postgres'

    ctx = ssl.create_default_context(cafile="")
    ctx.check_hostname = False
    ctx.verify_mode = ssl.CERT_NONE
    global db_loan_prediction
    db_loan_prediction = Gino()
    await db_loan_prediction.set_bind(db_product, echo=True)
    # await db_customer.set_bind(DBConstants.DB_customer, echo=True, ssl=ctx)
    print("db_loan_prediction:", end=" ")
    print(db_loan_prediction)
