package com.l;

import com.l.pojo.Category;
import com.l.pojo.New;
import com.l.pojo.User;
import com.l.service.NewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    NewService mapper;

    @Test
    void contextLoads() {
        New n = new New();
        Category category = new Category();
        User user = new User();
        n.setCategory(category);
        n.setUser(user);
        mapper.setPageShowNumber(5);
        System.err.println("总数" + mapper.selectSelectiveCount(n));
        for (New i : mapper.getPage(n, 1)) {
            System.out.println(i);
        }
    }

}
