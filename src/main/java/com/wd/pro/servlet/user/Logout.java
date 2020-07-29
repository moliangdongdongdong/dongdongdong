package com.wd.pro.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 03:22
 * @Description:    用户退出登录
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {

    private static final long serialVersionUID = 4969994648519318713L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");
        //退出登录实际就是清空session
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        session.removeAttribute("isLogin");
        //重定向到首页面
        response.sendRedirect("index.jsp");
    }
}
