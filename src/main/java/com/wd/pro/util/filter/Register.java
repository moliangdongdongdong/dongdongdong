package com.wd.pro.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 01:11
 * @Description: 过滤器过滤前端用户注册传过的，不符合规范的
 */
@WebFilter("/register")
public class Register implements javax.servlet.Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //我们用的是Http下的，所以要转化成其父类
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //设置字符集，防止有乱码出现
        req.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        resp.setContentType("text/html;charset=utf-8");

        //提交的时候不让用户名为空
        String userName = req.getParameter("userName");
        PrintWriter out = resp.getWriter();
        if (userName.equals("")) {
            out.write("<script>");
            out.write("alert('用户名称不能空');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;//不让其通过，执行return
        }

        //提交的时候不让手机号为空
        String mobile = req.getParameter("mobile");
        if (mobile.equals("")) {
            out.write("<script>");
            out.write("alert('手机号码不能空');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;//不让其通过，执行return
        }


        //提交的时候不让验证码为空
        //获取session
        HttpSession session = req.getSession();
        //jsp中的验证码
        String veryCode = req.getParameter("veryCode");
        //CodeSerlet中系统中的验证码
        String sysCode = (String) session.getAttribute("code");
        if(!sysCode.equals(veryCode)){
            out.write("<script>");
            out.write("alert('验证码输入有误');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;//不让其通过，执行return
        }

        chain.doFilter(req, resp);//让其通过执行这个

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
