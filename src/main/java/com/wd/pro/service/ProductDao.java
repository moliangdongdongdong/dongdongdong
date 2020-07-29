package com.wd.pro.service;

import com.wd.pro.dao.BaseDao;
import com.wd.pro.entity.Category;
import com.wd.pro.entity.Product;
import com.wd.pro.util.jdbc.BaseJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/7/1 19:56
 * @Description:    商品类
 */
public class ProductDao {
    /**
     * 功能描述:插入商品
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午7:58
     * @throws :
     * @author: 莫良咚咚咚
     */
    public static int insert(Product product) {
        //准备sql语句，插入商品
        String sql = "insert into product values(null,?,?,?,?,?,?,?)";

        Object[] params = {
                product.getProduct_name(),
                product.getProduct_desc(),
                product.getProduct_price(),
                product.getProduct_stock(),
                product.getProduct_fid(),
                product.getProduct_cid(),
                product.getProduct_filename()
        };
        return BaseDao.execuIUD(sql, params);
    }

    /**
     * 功能描述: 查询所有的商品
     *
     * @param:
     * @return:
     * @date: 2020/7/2 上午12:23
     * @throws :
     * @author: 莫良咚咚咚
     */
    public static ArrayList<Product> selectAllProduct() {
        ArrayList<Product> list = new ArrayList<Product>();
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        //准备sql语句
        String sql = "";

        try {
            conn = BaseJdbc.getConnection();
            //准备sql语句，查询所有分类
            sql = "select * from product ";

            pst = conn.prepareStatement(sql);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseJdbc.rollbackAndClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    /**
     * 功能描述: 通过父id查询所有商品
     *
     * @param:
     * @return:
     * @date: 2020/7/2 上午12:54
     * @throws :
     * @author: 莫良咚咚咚
     */
    public static ArrayList<Product> selectAllByFid(int fid) {
        ArrayList<Product> list = new ArrayList<Product>();
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        //准备sql语句
        String sql = "";

        try {
            conn = BaseJdbc.getConnection();
            //准备sql语句，查询所有分类
            sql = "select * from product where product_fid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,fid);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseJdbc.rollbackAndClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }



    /**
     * 功能描述:通过子id查询所有商品
     *
     * @param:
     * @return:
     * @date: 2020/7/2 上午1:00
     * @throws :
     * @author: 莫良咚咚咚
     */
    public static ArrayList<Product> selectAllByCid(int cid) {
        ArrayList<Product> list = new ArrayList<Product>();
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        //准备sql语句
        String sql = "";

        try {
            conn = BaseJdbc.getConnection();
            //准备sql语句，查询所有分类
            sql = "select * from product where product_cid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,cid);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseJdbc.rollbackAndClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 功能描述: 通过id查询一个商品
     *
     * @param:
     * @return:
     * @date: 2020/7/2 下午4:46
     * @throws :
     * @author: 莫良咚咚咚
     */
    public static Product selectById(int id) {
        Product product = null;
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        //准备sql语句
        String sql = "";

        try {
            conn = BaseJdbc.getConnection();
            //准备sql语句，查询所有分类
            sql = "select * from product where product_id = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1,id);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseJdbc.rollbackAndClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

}
