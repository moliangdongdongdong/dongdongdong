package com.wd.pro.util.filter;

import cn.hutool.system.UserInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/7/2 18:29
 * @Description:
 */
public class SystemFilter implements Filter {

    private static final List<String> STRINGS = new ArrayList<String>();

    //此处可以定义加载时要过滤的资源类型
    static {
        STRINGS.add("jsp");
        STRINGS.add("js");
        STRINGS.add("css");
        STRINGS.add("images");
        STRINGS.add("bmp");
        STRINGS.add("gif");
        STRINGS.add("jpg");
        STRINGS.add("jpeg");
        STRINGS.add("png");
    }


    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //通过过滤器实现编码方式的控制
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");

        String url = request.getRequestURI();
        String path = request.getContextPath();
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userName"); //此处用来判断浏览器缓存用户数据是否存在
        if (!url.contains("indexselect") && (!isAuth(url) || url.contains(".json"))) {
            if (null == userInfo || StringUtils.isBlank(userInfo.getName())) {
                String tip = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><script language='javascript'>window.parent.location.href='"
                        + path
                        + "/indexselect'</script></head><body></body></html>"; //此处用来后台请求跳转的路径，当请求到此处时，就会进入对应的后台路径中进行请求
                PrintWriter outprint = response.getWriter();
                outprint.write(tip);
                outprint.flush();
                return;
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public boolean isAuth(String url) {
        for (String string : STRINGS) {
            if (url.contains(string)) {
                return true;
            }
        }
        return false;
    }
}
