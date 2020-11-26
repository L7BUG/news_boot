package com.l;

import com.l.mapper.CategoryMapper;
import com.l.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    CategoryMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.selectAll());
        System.out.println(mapper.selectByPrimaryKey(1));
        Category category = new Category();
        category.setName("测试栏目");
        mapper.insertOne(category);
        System.out.println(category);
        category.setName("测试更新数据");
        System.out.println(mapper.updateByPrimaryKey(category));
        System.out.println(mapper.deleteByPrimaryKey(category.getId()));
    }
}
