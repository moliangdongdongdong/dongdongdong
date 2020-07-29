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
 * @Date: 2020/7/2 16:38
 * @Description:
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {

    private static final long serialVersionUID = 317868417151796933L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分别把父分类和子分类放到request域中
        ArrayList<Category> flist = CategoryDao.SelectAllCatChildAndFather("father");
        request.setAttribute("flist",flist);

        ArrayList<Category> clist = CategoryDao.SelectAllCatChildAndFather("child");
        request.setAttribute("clist",clist);

        String id = request.getParameter("id");

        Product product = null;

        if(id != null){
            product = ProductDao.selectById(Integer.parseInt(id));
            request.setAttribute("product", product);
        }

        if(product != null){
            Integer cid = product.getProduct_cid();

            ArrayList<Product> classlist = ProductDao.selectAllByCid(cid);
            request.setAttribute("classlist",classlist);

            Category cate = CategoryDao.selectById(cid);
            request.setAttribute("cate",cate);
        }

        //通过获取的id跳转向到前端界面
        request.getRequestDispatcher("productview.jsp").forward(request, response);

    }
}
