"""Module that manages database connection."""
from gino import Gino, create_engine

# from config import DBConstants

# pylint: disable=invalid-name
# Connect to the database
db_loan_prediction: Gino = Gino()


async def connect_db():
    import ssl
    ctx = ssl.create_default_context(cafile="")
    ctx.check_hostname = False
    ctx.verify_mode = ssl.CERT_NONE

    db_product = 'postgresql://postgres:password@localhost:5432/postgres'
    global db_loan_prediction
    await db_loan_prediction.set_bind(db_product, echo=True)

    print("Binding DB:", end=" ")
    print(db_loan_prediction)


async def disconnect_db():
    global db_loan_prediction
    await db_loan_prediction.pop_bind().close()
