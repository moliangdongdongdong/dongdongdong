package com.wd.pro.servlet.product;

import com.jspsmart.upload.*;
import com.wd.pro.entity.Product;
import com.wd.pro.service.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/7/1 16:28
 * @Description: 商品添加
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
    private static final long serialVersionUID = 6712186970112659247L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用于jsp上传图片所用的jar包中类，现在这个jspSmartUpload.jar包放到了webapp/WEB-INF中的lib文件夹中
        SmartUpload su = new SmartUpload();
        //初始化这个对象
        su.initialize(this.getServletConfig(), request, response);
        //上传
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取上传文件的对象  SmartUpload中的流
        Files files = su.getFiles();
        File file = files.getFile(0);
        //获取上传的文件名称
        String fname = "";
        if (!file.isMissing()) {
            fname = file.getFileName();

            try {
                su.save("images/product");
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }

        }else {

            PrintWriter out = response.getWriter();
            out.println("<script>");  //js开始
            out.println("sendVoice('"+fname+"');"); // 参数两边要加上单引号
            out.println("sendImg(\"param\")<strong>;</strong>"); //加上分号表示语句结束
            out.println("alert(\"附件不是gif,jpg,png或超出1M大小,请重新选择！\")<strong>;</strong>");
            out.println("</script>"); // js结束
            out.close();
        }

        Request req = su.getRequest();

        String pname = req.getParameter("productname");
        String id = req.getParameter("parentId");
        String price = req.getParameter("productprice");
        String desc = req.getParameter("productdesc");
        String stock = req.getParameter("productstock");

        Product product = new Product(
                0,
                pname,
                desc,
                Integer.parseInt(price),
                Integer.parseInt(stock),
                Integer.parseInt(id.split("-")[0]),
                Integer.parseInt(id.split("-")[1]),
                fname
        );

        int count = ProductDao.insert(product);

        if(count > 0){
            response.sendRedirect("admin_productselect");
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品添加失败');");
            out.write("location.href='manage/admin_toproductadd';");
            out.write("</script>");
            out.close();
        }

    }

}
