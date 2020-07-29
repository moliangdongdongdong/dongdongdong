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
 * @Date: 2020/6/30 14:07
 * @Description:    分类管理
 */
@WebServlet("/manage/admin_cateselect")
public class CateSelect extends HttpServlet {

    private static final long serialVersionUID = 2924241417492382356L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有分类，从CategoryDao里面的selectAllCate()方法
        ArrayList<Category> cateList = CategoryDao.SelectAllCate();
        request.setAttribute("catelist", cateList);

        //重定向，请求界面
        request.getRequestDispatcher("admin_cate.jsp").forward(request,response);
    }
}
