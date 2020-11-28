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
        mapper.setPageShowNumber(20);
        User user = new User();
        Role role = new Role(null, null, null);
        user.setUsername("a");
        role.setId(2);
        user.setRole(role);
        int numberPage = (int) (mapper.selectSelectiveCount(user) / mapper.getPageShowNumber() + 1);
        System.out.println(numberPage);
        for (int i = 1; i <= numberPage; i++) {
            for (User u : mapper.getPage(user, i)) {
                System.out.println(u);
            }
        }
    }

}
