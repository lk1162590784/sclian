package servlet;

import bean.Dept;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import dao.data;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //创建DAO
        data testpython1= new data();
        //从数据库里取数据
        //设置服务器响应时向JSP表示层传输数据的编码格式
        response.setContentType("text/html; charset=utf-8");
        //ArrayList对象转化为JSON对象
        JSONArray json = testpython1.getdata();
        //控制台显示JSON
        //返回到JSP
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        //关闭输出流
        writer.close();
    }
}
