package com.wd.pro.servlet.category;

import com.wd.pro.service.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 22:56
 * @Description:    删除业务
 */
@WebServlet("/manage/admin_docatedel")
public class DoCateDel extends HttpServlet {
    private static final long serialVersionUID = -5208969449844360717L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryDao.del(id);
        response.sendRedirect("admin_cateselect");
    }
}
