package dao;

import bean.Dept;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cplian {
    public ArrayList<String> getlian(){
        String lian;
        ArrayList<String> result = new ArrayList<>();
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是cgjr
        String url="jdbc:mysql://localhost:3306/lian?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="root";
        String password="123456";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();

//            执行查询语句
            String sql = "SELECT distinct fenlei FROM sclian where cplian='食品行业产业链'";//我的表格叫persons
            ResultSet resultSet = statement.executeQuery(sql);
           System.out.println("------------");
//            打印查询出来的东西
            while (resultSet.next()) {
                result.add(resultSet.getString("fenlei"));


            }
           System.out.println(result);
          System.out.println(getType(result));



//            关闭连接
            resultSet.close();
            con.close();
            System.out.println("数据库已关闭连接");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }


        return  result;
    }
    public static String getType(Object o){
        return o.getClass().toString(); //使用int类型的getClass()方法
    }


    public static void main(String[] args) {
        cplian cplian = new cplian();
        ArrayList<String> result = new ArrayList<>();
        result =cplian.getlian();
        System.out.println(result);
    }
}
