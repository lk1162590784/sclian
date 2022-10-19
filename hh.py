import pandas as pd
import requests
import json
import pymysql
conn = pymysql.connect(host="localhost",port=3306,user="root",passwd="123456",db="lian" )
#获取一个游标对象
cursor=conn.cursor()
url = 'http://gxt.hebei.gov.cn/main/industrialinfo/getIndexList'
area = requests.get(url).json()
data = area['data']
# print(data)
a= data['list']
b=json.loads(a)
c1=b['total']
c2=b['rows']
print(c2)
for i in range(len(c2)):
    l=c2[i]
    #sql语句中，用%s做占位符，参数用一个元组
    sql="insert into sclian values(%s,%s,%s,%s,%s,%s)"
    param=(l['id'],l['dwmc'],l['xqmc'],l['sscyl'],l['sshy'],l['cpfl1'])
    print(param)
    #执行数据库插入
    cursor.execute(sql,param)
#提交
conn.commit()
#关闭连接
conn.close()
cursor.close()