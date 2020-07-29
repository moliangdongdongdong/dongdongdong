package com.wd.pro.servlet.category;

import com.wd.pro.entity.Category;
import com.wd.pro.service.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 18:00
 * @Description:  修改商品
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
    private static final long serialVersionUID = -3577522780495057726L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集，防止有乱码出现
        request.setCharacterEncoding("utf-8");
        //使客户端浏览器，区分不同种类的数据,并且根据设置的不同的“编码方式（utf-8）”调用浏览器内不同的程序嵌入模块来处理相应的数据
        response.setContentType("text/html;charset=utf-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer parentId = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("classname");

        Category cate = new Category(id, name, parentId);
        CategoryDao.update(cate);
        //重定向到 商品页面
        response.sendRedirect("admin_cateselect");
    }
}
