package com.wd.pro.service;

import com.wd.pro.dao.BaseDao;
import com.wd.pro.entity.Category;
import com.wd.pro.entity.Users;
import com.wd.pro.util.jdbc.BaseJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 14:09
 * @Description: 处理分类增删改查的
 */
public class CategoryDao {
    /**
     * 功能描述: 查询所有的分类
     *
     * @throws :
     * @param:
     * @return:
     * @date: 2020/6/30 下午2:11
     * @author: 莫良咚咚咚
     */
    public static ArrayList<Category> SelectAllCate() {
        ArrayList<Category> list = new ArrayList<Category>();
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
            sql = "select * from category ";

            pst = conn.prepareStatement(sql);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                Category cate = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
                list.add(cate);
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
     * 功能描述: 插入商品到数据库中
     *
     * @throws :
     * @param:
     * @return:
     * @date: 2020/6/30 下午5:08
     * @author: 莫良咚咚咚
     */
    public static int insert(Category cate) {
        //准备sql语句，插入用户
        String sql = "insert into category values(null,?,?)";

        Object[] params = {
                cate.getCate_name(),
                cate.getCate_parent_id()
        };
        return BaseDao.execuIUD(sql, params);
    }


    /**
     * 功能描述:通过id获取到分类
     *
     * @throws :
     * @param:
     * @return:
     * @date: 2020/6/30 下午5:25
     * @author: 莫良咚咚咚
     */
    public static Category selectById(int id) {
        Category cate = null;
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        try {
            conn = BaseJdbc.getConnection();
            //准备sql语句
            String sql = "select * from category where cate_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                cate = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseJdbc.rollbackAndClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cate;
    }

    /**
     * 功能描述: 修改商品的方法
     *
     * @throws :
     * @param:
     * @return:
     * @date: 2020/6/30 下午6:16
     * @author: 莫良咚咚咚
     */
    public static int update(Category cate) {
        //准备sql语句，修改用户
        String sql = "update category set cate_name = ?, cate_parent_id = ? where cate_id = ?";

        Object[] params = {
                cate.getCate_name(),
                cate.getCate_parent_id(),
                cate.getCate_id()

        };
        return BaseDao.execuIUD(sql, params);
    }

    /**
     * 功能描述: 通过id删除分类
     *
     * @throws :
     * @param:
     * @return:
     * @date: 2020/7/1 上午12:50
     * @author: 莫良咚咚咚
     */
    public static int del(int id) {
        String sql = "delete from category where cate_id = ?";
        Object[] params = {id};
        return BaseDao.execuIUD(sql, params);
    }

    /**
     * 功能描述: 查询子分类和父级分类
     *
     * @throws :
     * @param:设置flag=“father”父分类 flag=“child”子分类
     * @return:
     * @date: 2020/7/1 上午12:51
     * @author: 莫良咚咚咚
     */
    public static ArrayList<Category> SelectAllCatChildAndFather(String flag) {
        ArrayList<Category> list = new ArrayList<Category>();
        //建立连接
        Connection conn = null;
        PreparedStatement pst = null;
        //获取结果集
        ResultSet rs = null;
        //准备sql语句
        String sql = "";

        try {
            conn = BaseJdbc.getConnection();
            if (flag != null && flag.equals("father")) {
                //准备sql语句，查询父分类
                sql = "select * from category where cate_parent_id = 0 ";
            }else{
                //准备sql语句，查询子分类
                sql = "select * from category where cate_parent_id != 0 ";
            }
            pst = conn.prepareStatement(sql);
                
            //获取结果集，循环找到分类
            rs = pst.executeQuery();
            while (rs.next()) {
                Category cate = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
                list.add(cate);
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

}
