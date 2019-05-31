import com.lee.mapper.CategoryMapper;
import com.lee.pojo.Category;
import com.lee.service.CategoryService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by liboar on 2019/5/31.
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SqlSession sqlSession = (SqlSession) ac.getBean("sqlSession");
//        CategoryMapper categoryMapper =  sqlSession.getMapper(CategoryMapper.class);
//        System.out.println(categoryMapper.listCategory());
        System.out.println(ac);
        CategoryService categoryService = ac.getBean("csim",CategoryService.class);
        List<Category> list = categoryService.list();
        for(Category c : list){
            System.out.println(c.getName());
        }
    }
}
