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
 * @Date: 2020/6/30 16:56
 * @Description:  用户添加商品,插入到数据库中
 */
@WebServlet("/manage/admin_dousercate")
public class DoUserCate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有分类，从CategoryDao里面的selectAllCate()方法
        ArrayList<Category> cateList = CategoryDao.SelectAllCate();
        request.setAttribute("catelist", cateList);

        Integer parentId = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("classname");

        Category cate = new Category(0, name, parentId);
        CategoryDao.insert(cate);
        //重定向到 商品页面
        response.sendRedirect("admin_cateselect");

    }

}
