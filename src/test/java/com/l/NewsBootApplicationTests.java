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
        New t = mapper.selectByPrimaryKey(6);
        User user = t.getUser();
        user.setId(1);
        t.setUser(user);
        Category category = t.getCategory();
        category.setId(4);
        t.setCategory(category);
        mapper.updateByPrimaryKeySelective(t);
    }
}
