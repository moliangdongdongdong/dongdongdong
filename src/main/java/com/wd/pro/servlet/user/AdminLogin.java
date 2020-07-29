package com.wd.pro.servlet.user;

import com.wd.pro.entity.Users;
import com.wd.pro.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 03:42
 * @Description:    后台管理员登录
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
    private static final long serialVersionUID = 8556126862158827808L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");
        //设置字符集用户名和密码
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        int count = UserDao.selectByNM(userName, passWord);

        if (count > 0) {
            //在数据库中查找的用户，角色是2的才有权限登录后台
            Users users = UserDao.selectAdmin(userName, passWord);
            //通过session获取整个的用户信息
            HttpSession session = request.getSession();
            //从session里面获取用户
            session.setAttribute("name", users);
            //设置一个点，标记位，以后判断isLogin是否为1,就可以判断是否登录成功
            session.setAttribute("isLogin", "1");
            //角色是2的才有权限登录后台
            if(users.getUser_status() == 2){
                //设置一个点，标记位，以后判断isLogin是否为1,就可以判断是否登录成功，后台的
                session.setAttribute("isAdminLogin", "1");

                //等于2重定向到后台index.jsp,也就是后台首页
                response.sendRedirect("/miaomiaoShoppingMall/manage/admin_index.jsp");
            }else {
                //不等于2重定向到钱台index.jsp,也就是前台首页
                response.sendRedirect("/miaomiaoShoppingMall/index.jsp");

            }

        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户名或密码错误，请重新登录');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }
    }
}

