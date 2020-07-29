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
 * @Date: 2020/6/30 16:31
 * @Description:    商品添加
 */
@WebServlet("/manage/admin_tocateadd")
public class ToCateAdd extends HttpServlet {
    private static final long serialVersionUID = -7069416948245704913L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有分类，从CategoryDao里面的selectAllCate()方法
        ArrayList<Category> cateList = CategoryDao.SelectAllCate();
        request.setAttribute("catelist", cateList);

        //重定向，请求界面
        request.getRequestDispatcher("admin_cateadd.jsp").forward(request,response);
    }
}
