package com.lee.controller;

import com.github.pagehelper.PageHelper;
import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import com.lee.service.impl.CategoryServiceImpl;
import com.lee.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    //分页-----------------------------------------------------------------------------------

    @RequestMapping("/listCategory")
    public ModelAndView listCategory(Page page){ //框架会自动给形参new对象并赋值
        System.out.println("/listCategory");

        //PageHeplerf分页工具的使用
        PageHelper.offsetPage(page.getStart(),5);//这里要注意边界问题
        List<Category> categorys = categoryService.list();

        //数据库limit关键字的使用
        //page.caculateLast(categoryService.total());  //取出总数并传递给page对象，计算末页位置
        //List<Category> categorys = categoryService.list(page);

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

    //CRUD-------------------------------------------------------------------------

    @RequestMapping("addCategory")
    public ModelAndView addCategory(Category category){
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }
    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(Category category){
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }
    @RequestMapping("editCategory")
    public ModelAndView editCategory(Category category){
        Category c= categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("c", c);
        return mav;
    }
    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category category){
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    //json方式--------------------------------------------------------------------------
    //responseBody表示把返回的数据转换为请求包头中的指定格式xml/json，直接使用response流写入
    @ResponseBody
    @RequestMapping("/submitCategory")
    //requesBody表示把post/put请求报文中的xml/json格式转化为Java格式
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
        Category c = new Category();
        c.setId(100);
        c.setName("第100个分类");
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(c));

        System.out.println(json.toJSONString());
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
        System.out.println(JSONObject.toJSON(cs).toString());
        return JSONObject.toJSON(cs).toString();
    }
}
