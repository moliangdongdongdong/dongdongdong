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
 * @Date: 2020/6/30 06:17
 * @Description: 过滤器拦截后台已经退出登录了，但是不是管理员的可能会通过网址输入，还可以进入到后台的bug
 * 通过“/manage/*”过滤，但是不能过滤掉后台的入口/manage/login.jsp
 */

@WebFilter("/manage/*")
public class AdminLogin implements Filter {
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

        PrintWriter out = resp.getWriter();

        //获取session
        HttpSession session = req.getSession();
        //通过session获取，jsp中的后台中的点，也就是标记位 isAdminLogin
        String flag = (String) session.getAttribute("isAdminLogin");

        /**
         * 功能描述: 排除不要拦截的文件“/manage/login.jsp”，
         * 还有登录界面/manage/login.jsp中的“${pageContext.request.contextPath}/manage/adminlogin”提交的位置也不能拦截，
         * 还有相应的css等文件
         *
         * @param: [request, response, chain]
         * @return: void
         * @date: 2020/6/30 上午6:32
         * @throws :
         * @author: 莫良咚咚咚
         */
        //获取访问的路径地址
        String request_url = req.getRequestURI();
        //获取访问的路径地址的前半部分
        String contextPath = req.getContextPath();
        //获取除了路径地址“request_url”长度为“contextPath.length()”后面的路径，也就是找到“/manage/login.jsp”
        String uri = request_url.substring(contextPath.length());
        //判断如果uri包含login.jsp，就为true
        //反过来想，就是我们后台命名的时候都有"admin_"这样的前缀，那么去除了就可以了
        if (uri.contains("admin_")) {
            //再次判断标记位中是不是登录的后台管理员，是的话，就让其通过，不过滤
            if (flag != null && flag.equals("1")) {
                chain.doFilter(req, resp);//让其通过执行这个
            } else {
                out.write("<script>");
                out.write("alert('请先登录');");
                out.write("location.href='login.jsp';");
                out.write("</script>");
                out.close();
                return;//不让其通过，执行return
            }
        } else {
            //只要是不包含“admin_”的，都不过滤，都通过
            chain.doFilter(req, resp);//让其通过执行这个
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
