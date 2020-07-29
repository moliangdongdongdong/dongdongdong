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
 * @Date: 2020/6/29 22:47
 * @Description:
 */
@WebServlet("/checkusernum")
public class CheckUserNum extends HttpServlet {

    private static final long serialVersionUID = -4456870323083175973L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num =  request.getParameter("num");
        //从codeSerlet里面获取session码
        HttpSession session = request.getSession();
        //获取code码
        String  sysCode = (String) session.getAttribute("code");

        PrintWriter out = response.getWriter();
        if(sysCode.equals(num)){
            out.print("true");
        }else{
            out.print("false");
        }
        //关闭流
        out.close();

    }
}
