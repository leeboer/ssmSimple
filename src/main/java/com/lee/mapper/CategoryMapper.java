package com.lee.mapper;

import com.lee.pojo.Category;
import com.lee.util.Page;

import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
public interface CategoryMapper {

    public int addCategory(Category category);

    public void deleteCategory(int id);

    public Category getCategory(int id);

    public int updateCategory(Category category);

    public List<Category> listCategory();

    public List<Category> list(Page page);

    public int total();

}
