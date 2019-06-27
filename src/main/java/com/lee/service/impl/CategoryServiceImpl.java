package com.lee.service.impl;

import com.lee.mapper.CategoryMapper;
import com.lee.util.Page;
import org.springframework.stereotype.Service;
import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Resource
    private CategoryMapper categoryMapper ;

    @Override
    public void add(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void delete(Category category) {
        categoryMapper.deleteCategory(category.getId());
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.getCategory(id);
    }

    public List<Category> list() {
        return categoryMapper.listCategory();
    }

    // 下列为数据库limit关键字分页所用方法
    //获取总数
    public int total() {
        return categoryMapper.total();
    }
    //分页
    public List<Category> list(Page page) {
        //解决上一页下一页报错问题
        if(page.getStart()<0)page.setStart(0);
        if(page.getStart()>page.getLast())page.setStart(page.getLast());
        return categoryMapper.list(page);
    }

    //测试事务用的方法
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public void addTwo() {
        Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.addCategory(c1);

        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.addCategory(c2);
    }

    //测试事务用的方法
    public void deleteAll() {
        List<Category> cs = list();
        for (Category c : cs) {

            categoryMapper.deleteCategory(c.getId());
        }
    }

}
