package com.wd.pro.servlet.user;

import com.wd.pro.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/29 19:46
 * @Description: 检查用户从function.js中提交过来的id是不是存在
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {
    /**
     * 功能描述:序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性
     *
     * @param:
     * @return:
     * @date: 2020/6/29 下午7:47
     * @throws :
     * @author: 莫良咚咚咚
     */
    private static final long serialVersionUID = 7716201204696411518L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");
        //声明从function.js中传过来的name
        String name = request.getParameter("name");

        int count = UserDao.selectByName(name);
        PrintWriter out = response.getWriter();
        if(count > 0){
            out.print("false");
        }else{
            out.print("true");
        }
        //关闭流
        out.close();
    }
}
