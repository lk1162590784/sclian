package dao;


/**
 * Created by Administrator on 2017/12/24.
 */

import bean.Dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jdbc {
    public List<Dept> getdata(String lian){
        List<Dept> depts = new ArrayList<>();
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
            String sql = "select * FROM sclian WHERE fenlei = '"+lian+"'and cplian='食品行业产业链'";
            System.out.println(sql);//我的表格叫persons
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("------------");
//            打印查询出来的东西
            while (resultSet.next()) {
                Dept ur = new Dept();
                ur.setId(resultSet.getString("id"));
                ur.setCpcompany(resultSet.getString("company"));
                ur.setCplian(resultSet.getString("cplian"));
                ur.setCpname(resultSet.getString("cpname"));
                depts.add(ur);
            }
            System.out.println(depts);



//            关闭连接
            resultSet.close();
            con.close();
            System.out.println("数据库已关闭连接");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }


        return depts;
    }
    public static void main(String[] args) {
        List<Dept> dept = new ArrayList<>();
        Jdbc jdbc = new Jdbc();
        dept=jdbc.getdata("农副产品加工");
        System.out.println(dept);
    }
}
