from fastapi import FastAPI, Depends, Request
from mysql.connector import cursor
from db import get_db
from fastapi.middleware.cors import CORSMiddleware
import json
from pydantic import BaseModel
import mysql.connector

class Payload(BaseModel):
    name: str
    password: str
    ConfirmPassword: str

# class UpDate(BaseModel):
#     taskid: str
#     status: str
#     download: str

app = FastAPI()

# 添加CORS中间件
app.add_middleware(
    CORSMiddleware,
    # allow_origins=["http://localhost:8081","123.207.73.194:80"],  # 允许的源
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# 获取全部信息
@app.get("/users/")
async def get_users(db: mysql.connector.MySQLConnection = Depends(get_db)):
    query = "SELECT * FROM app"
    cursor = db.cursor()
    cursor.execute(query)
    result = cursor.fetchall()
    if result:
        return {"users": result}
    else:
        return {"error": "User not found"}


# 添加
@app.post("/add")
async def add(request: Request, user: Payload, db: mysql.connector.MySQLConnection = Depends(get_db)):
    # 获取请求体的JSON数据
    request_json = await request.json()
    print("db", db)
    # 打印请求体的JSON数据
    print("Request JSON Data:", request_json)

    query = "INSERT INTO digitalhuman (name, password) VALUES (%s, %s)"

    # 创建游标对象
    cursor = db.cursor()

    # 执行数据库插入操作
    try:
        cursor.execute(query, (user.name, user.password))
        db.commit()
    except Exception as e:
        print("Error:", str(e))
    finally:
        cursor.close()  # 关闭游标
        return {"result": "success"}

# # 删除
# @app.get("/delete/{taskid}")
# async def delete(taskid: str, db: mysql.connector.MySQLConnection = Depends(get_db)):
#     query = "DELETE FROM digitalhuman WHERE taskid = %s"
#     cursor = db.cursor()
#
#     try:
#         cursor.execute(query, (taskid,))
#         db.commit()  # 提交更改
#         return {"result": "success"}
#     except Exception as e:
#         print("Error:", str(e))
#         return {"result": "failure", "error": str(e)}
#     finally:
#         cursor.close()

# 更新status和download数据
# @app.put("/update")
# async def update(request: Request, data: UpDate, db: mysql.connector.MySQLConnection = Depends(get_db)):
#     print("data",data)
#     if data.status is not None and data.download is None:
#         query = "UPDATE digitalhuman SET status = %s WHERE taskid = %s"
#         parameters = (data.status, data.taskid)
#     elif data.status is not None and data.download is not None:
#         query = "UPDATE digitalhuman SET status = %s, download = %s WHERE taskid = %s"
#         parameters = (data.status, data.download, data.taskid)
#         print("parameters",parameters)
#     else:
#         return {"result": "failure", "error": "Invalid parameters"}
#
#     # 创建游标对象
#     cursor = db.cursor()
#     try:
#         cursor.execute(query, parameters)
#         db.commit()  # 提交更改
#         return {"result": "success"}
#     except Exception as e:
#         print("Error:", str(e))
#         return {"result": "failure", "error": str(e)}
#     finally:
#         cursor.close()
    



if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app=app, host="127.0.0.1", port=9000)