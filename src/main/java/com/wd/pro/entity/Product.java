package com.wd.pro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/7/1 16:12
 * @Description:    商品类
 */
public class Product {
    /**
     * 功能描述: 商品id
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:16
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer product_id ;
    /**
     * 功能描述:商品名称
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:16
     * @throws :
     * @author: 莫良咚咚咚
     */
    private String product_name;
    /**
     * 功能描述:商品介绍
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:16
     * @throws :
     * @author: 莫良咚咚咚
     */
    private String product_desc ;
    /**
     * 功能描述:商品价格
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:17
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer product_price;
    /**
     * 功能描述: 商品库存
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:16
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer product_stock ;
    /**
     * 功能描述:商品父级id，所属父级分类
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:17
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer product_fid;
    /**
     * 功能描述: 商品子级分类id，所属子级分类
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:20
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer product_cid ;
    /**
     * 功能描述:商品图片名称
     *
     * @param:
     * @return:
     * @date: 2020/7/1 下午4:21
     * @throws :
     * @author: 莫良咚咚咚
     */
    private String product_filename;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(Integer product_stock) {
        this.product_stock = product_stock;
    }

    public Integer getProduct_fid() {
        return product_fid;
    }

    public void setProduct_fid(Integer product_fid) {
        this.product_fid = product_fid;
    }

    public Integer getProduct_cid() {
        return product_cid;
    }

    public void setProduct_cid(Integer product_cid) {
        this.product_cid = product_cid;
    }

    public String getProduct_filename() {
        return product_filename;
    }

    public void setProduct_filename(String product_filename) {
        this.product_filename = product_filename;
    }

    public Product() {
    }

    public Product(Integer product_id, String product_name, String product_desc, Integer product_price, Integer product_stock, Integer product_fid, Integer product_cid, String product_filename) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_fid = product_fid;
        this.product_cid = product_cid;
        this.product_filename = product_filename;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", product_price=" + product_price +
                ", product_stock=" + product_stock +
                ", product_fid=" + product_fid +
                ", product_cid=" + product_cid +
                ", product_filename='" + product_filename + '\'' +
                '}';
    }
}
