package com.wd.pro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: 莫良咚咚咚
 * @Date: 2020/6/30 13:58
 * @Description:    二级分类  父级分类  子级分类
 */
public class Category {
    /**
     * 功能描述: 分类id
     *
     * @param:
     * @return:
     * @date: 2020/6/30 下午2:00
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer cate_id;
    /**
     * 功能描述:  分类名称
     *
     * @param:
     * @return:
     * @date: 2020/6/30 下午2:01
     * @throws :
     * @author: 莫良咚咚咚
     */
    private String cate_name;
    /**
     * 功能描述: 父级id
     *
     * @param:
     * @return:
     * @date: 2020/6/30 下午2:01
     * @throws :
     * @author: 莫良咚咚咚
     */
    private Integer cate_parent_id;

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_parent_id() {
        return cate_parent_id;
    }

    public void setCate_parent_id(Integer cate_parent_id) {
        this.cate_parent_id = cate_parent_id;
    }

    public Category() {
    }

    public Category(Integer cate_id, String cate_name, Integer cate_parent_id) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.cate_parent_id = cate_parent_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cate_id=" + cate_id +
                ", cate_name='" + cate_name + '\'' +
                ", cate_parent_id=" + cate_parent_id +
                '}';
    }
}
