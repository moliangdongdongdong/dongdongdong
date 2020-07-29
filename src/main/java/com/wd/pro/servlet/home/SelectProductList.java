package com.wd.pro.servlet.home;

import com.wd.pro.entity.Category;
import com.wd.pro.entity.Product;
import com.wd.pro.service.CategoryDao;
import com.wd.pro.service.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/7/1 02:11
 * @Description:    查询分类并且重定向到产品页面
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
    private static final long serialVersionUID = -205072516886994440L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分别把父分类和子分类放到request域中
        ArrayList<Category> flist = CategoryDao.SelectAllCatChildAndFather("father");
        request.setAttribute("flist",flist);

        ArrayList<Category> clist = CategoryDao.SelectAllCatChildAndFather("child");
        request.setAttribute("clist",clist);

        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        //定义一个id，前端页面无论获取到哪个分类的id都可以跳转页面
        int id = 0;
        ArrayList<Product> list = null;
        if(fid != null){
            id = Integer.parseInt(fid);
            list = ProductDao.selectAllByFid(id);
        }

        if(cid!= null){
            id = Integer.parseInt(cid);
            list = ProductDao.selectAllByCid(id);
        }

        //通过id获取分类对象，从而获取cate_name
        Category category = CategoryDao.selectById(id);
        String name = category.getCate_name();

        //将得到的name放到request域中
        request.setAttribute("title",name);
        //通过获取的list放到request域中
        request.setAttribute("list", list);

        //通过获取的id跳转向到前端界面
        request.getRequestDispatcher("productlist.jsp").forward(request, response);


    }

}
