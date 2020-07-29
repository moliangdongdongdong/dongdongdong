package com.wd.pro.servlet.user;

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
 * @Date: 2020/6/30 04:22
 * @Description:    后台退出登录
 */
@WebServlet("/manage/admin_logout")
public class AdminLogout extends HttpServlet {

    private static final long serialVersionUID = -1399735635234127890L;

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
        session.removeAttribute("isAdminLogin");

        PrintWriter out = response.getWriter();
        out.write("<script>");
        out.write("alert('退出成功！');");
        out.write("location.href='login.jsp';");
        out.write("</script>");
        out.close();

    }
}
