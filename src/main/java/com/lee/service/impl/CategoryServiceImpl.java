package com.lee.service.impl;

import com.lee.mapper.CategoryMapper;
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

}
