package com.lee.service.impl;

import com.lee.mapper.CategoryMapper;
import com.lee.util.Page;
import org.springframework.stereotype.Service;
import com.lee.pojo.Category;
import com.lee.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Resource
    CategoryMapper categoryMapper ;
    public List<Category> list() {
        return categoryMapper.listCategory();
    }

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
}
