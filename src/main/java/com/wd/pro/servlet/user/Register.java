package com.wd.pro.servlet.user;

import com.wd.pro.entity.Users;
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
 * @Date: 2020/6/30 00:16
 * @Description: 注册
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    /**
     * 功能描述: 客户端把数据传送到服务器端,隐藏传送给服务器的任何数据
     *
     * @param:
     * @return:
     * @date: 2020/6/30 上午12:20
     * @throws :
     * @author: 莫良咚咚咚
     */
    private static final long serialVersionUID = -7314843494296394380L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userName");
        String name = request.getParameter("name");
        String pwd = request.getParameter("passWord");
        String mobile = request.getParameter("mobile");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String regist = request.getParameter("register");
        String birth = request.getParameter("birthday");
        String usercode = request.getParameter("usercode");
        String address = request.getParameter("address");

        //创建用户实体类,把数据加到数据库中
        Users users = new Users(username, name, pwd, mobile, sex, email, regist, birth, usercode, address, 1);

        System.out.println(users);
        //加入到数据库用户表中
        int count = UserDao.innsert(users);
        //成功失败的网页重定向
        if (count > 0) {
            response.sendRedirect("login.jsp");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('注册失败，请重新填写')");
            out.write("location.href='reg.jsp'");
            out.write("</script>");

            out.close();
        }
    }
}

