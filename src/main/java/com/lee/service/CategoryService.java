package com.lee.service;

import com.lee.pojo.Category;
import com.lee.util.Page;

import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
public interface CategoryService {
    //增
    public void add(Category category);
    //删
    public void delete(Category category);
    //改
    public void update(Category category);
    //查一
    public Category get(int id);
    //查所有
    public List<Category> list();

    // 下列为数据库limit关键字分页所用方法
    public int total();
    public List<Category> list(Page page);


    //事务要用到的方法
    public void addTwo();
    public void deleteAll();
}
