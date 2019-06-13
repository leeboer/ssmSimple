package com.lee.service;

import com.lee.pojo.Category;
import com.lee.util.Page;

import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
public interface CategoryService {
    public List<Category> list();

    public int total();

    public List<Category> list(Page page);
}
