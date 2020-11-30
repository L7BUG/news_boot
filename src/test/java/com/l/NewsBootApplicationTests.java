package com.l;

import com.l.pojo.Role;
import com.l.pojo.User;
import com.l.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    UserService mapper;

    @Test
    void contextLoads() {
        mapper.setPageShowNumber(5);
        User user = new User();
        Role role = new Role();
        user.setRole(role);
        System.out.println(user);
        System.out.println(mapper.selectSelectiveCount(user));
    }

}
