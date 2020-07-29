package com.wd.pro.servlet.product;

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
 * @Date: 2020/7/1 14:39
 * @Description:    转向商品
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
    private static final long serialVersionUID = 5669363574175806205L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> plist = ProductDao.selectAllProduct();

        request.setAttribute("plist", plist);

        //转向商品页面
        request.getRequestDispatcher("admin_product.jsp").forward(request,response);
    }
}
