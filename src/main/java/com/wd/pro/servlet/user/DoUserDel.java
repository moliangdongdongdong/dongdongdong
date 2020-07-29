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
 * @Date: 2020/6/27 15:33
 * @Description:
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
    /**
     * 功能描述:序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性
     *
     * @param:
     * @return:
     * @date: 2020/6/27 下午3:36
     * @throws :
     * @author: 莫良咚咚咚
     */
    private static final long serialVersionUID = 5760235410048747420L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");

        //加入到数据库用户表中
        int count = UserDao.del(id);
        //成功失败的网页重定向
        if (count > 0) {
            response.sendRedirect("/miaomiaoShoppingMall/manage/admin_douserselect?cp=" + request.getParameter("cpage"));
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='/manage/admin_douserselect?cp=" + request.getParameter("cpage") + "'");
            out.write("</script>");

            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");
        //批量获取用户
        String[] ids = request.getParameterValues("id[]");
        //批量删除用户
        if (ids != null) {
            for (int i = 0; i <ids.length ; i++) {
                //加入到数据库用户表中
                UserDao.del(ids[i]);
            }
            //成功失败的网页重定向
            response.sendRedirect("/miaomiaoShoppingMall/manage/admin_douserselect?");
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('请选择您要删除的用户！')");
            out.write("location.href='/manage/admin_douserselect?cp=" + request.getParameter("cpage") + "'");
            out.write("/<script>");
        }
    }
}

