package com.wd.pro.servlet.product;

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
 * @Date: 2020/7/1 14:48
 * @Description:    转向商品添加
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
    private static final long serialVersionUID = -4896196530389804377L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分别把父分类和子分类放到request域中
        ArrayList<Category> flist = CategoryDao.SelectAllCatChildAndFather("father");
        request.setAttribute("flist",flist);

        ArrayList<Category> clist = CategoryDao.SelectAllCatChildAndFather("child");
        request.setAttribute("clist",clist);
        //转向商品添加页面
        request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
    }
}
