package com.l;

import com.l.mapper.NewMapper;
import com.l.pojo.Category;
import com.l.pojo.New;
import com.l.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    NewMapper mapper;

    @Test
    void contextLoads() {
        New t = new New();
        User user = new User();
        t.setTitle("mapper测试数据");
        Category category = new Category();
        t.setCategory(category);
        t.setUser(user);
        System.out.println(mapper.deleteBySelective(t));
    }
}
