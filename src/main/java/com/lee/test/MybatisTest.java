package com.lee.test;

import com.lee.mapper.CategoryMapper;
import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import com.lee.service.impl.CategoryServiceImpl;
import com.lee.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryService categoryService;

    @Test
    public void test(){
        categoryService.deleteAll();
        categoryService.addTwo();
    }

////  @Test
//    public void testAdd() {
//        for (int i = 0; i < 100; i++) {
//            Category category = new Category();
//            category.setName("new Category");
//            categoryMapper.addCategory(category);
//        }
//
//    }
//
//    @Test
//    public void testTotal() {
//        int total = categoryMapper.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList() {
//        Page p = new Page();
//        p.setStart(2);
//        p.setCount(3);
//        List<Category> cs=categoryMapper.list(p);
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//    }

}