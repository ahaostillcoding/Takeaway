from fastapi import Depends
import mysql.connector


def get_db_connection():
    connection = mysql.connector.connect(
        host='127.0.0.1',
        port=3306,
        user="root",
        password="emYRi7D3jpd4aGYf",
        password="emYRi7D3jpd4aGYf",
        database="app",
        autocommit=True
    )
    return connection

# def get_db():
#     connection = get_db_connection()
#     db = connection.cursor()

#     try:
#         yield db
#     finally:
#         db.close()
#         connection.close()

def get_db():
    connection = get_db_connection()

    try:
        yield connection
    finally:
        connection.close()