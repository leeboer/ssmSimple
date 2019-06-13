package com.lee.controller;

import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import com.lee.service.impl.CategoryServiceImpl;
import com.lee.util.Page;
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
    public ModelAndView listCategory(Page page){ //框架会自动给形参new对象并赋值
        System.out.println("/listCategory");
        //取出总数并传递给page对象，计算末页位置
        page.caculateLast(categoryService.total());

        List<Category> categorys = categoryService.list(page);
        for(Category c : categorys){
            System.out.println(c.getName());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("cs",categorys);
        //下面这一个语句框架会自动加上
        //mv.addObject("page",page);
        mv.setViewName("listCategory");
        return mv;
    }
}
