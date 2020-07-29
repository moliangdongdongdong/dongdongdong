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
 * @Date: 2020/6/30 17:18
 * @Description:
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {

    private static final long serialVersionUID = -4036861321337333560L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取一条数据  通过id
        int id = Integer.parseInt(request.getParameter("id"));
        Category cate  = CategoryDao.selectById(id);

        //获取所有分类，从CategoryDao里面的selectAllCate()方法
        ArrayList<Category> cateList = CategoryDao.SelectAllCate();
        //把从数据库中获取的单条数据还有多条数据放到request域中
        request.setAttribute("catelist", cateList);
        request.setAttribute("cate1", cate);

        //重定向，请求界面
        request.getRequestDispatcher("admin_catemodify.jsp").forward(request,response);
    }
}
