package com.lee.controller;

import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import com.lee.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
@Controller
//@RequestMapping("")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @RequestMapping("/listCategory")
    public ModelAndView listCategory(){
        System.out.println("/listCategory");
        List<Category> categorys = categoryService.list();
        for(Category c : categorys){
            System.out.println(c.getName());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("cs",categorys);
        mv.setViewName("listCategory");
        return mv;
    }
}
