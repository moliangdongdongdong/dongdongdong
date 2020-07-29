package com.wd.pro.servlet.home;

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
 * @Date: 2020/7/1 00:43
 * @Description:    前端分类查询
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {

    private static final long serialVersionUID = 4436088663871695293L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分别把父分类和子分类放到request域中
        ArrayList<Category> flist = CategoryDao.SelectAllCatChildAndFather("father");
        request.setAttribute("flist",flist);

        ArrayList<Category> clist = CategoryDao.SelectAllCatChildAndFather("child");
        request.setAttribute("clist",clist);

        //重定向到前端界面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
