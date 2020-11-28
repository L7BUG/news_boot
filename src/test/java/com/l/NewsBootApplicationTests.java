package com.l;

import com.l.mapper.UserMapper;
import com.l.pojo.Role;
import com.l.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    UserMapper mapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("c");
        Role role = new Role(2, null, null);
        user.setRole(role);
        long l = mapper.selectSelectiveCount(user);
        System.out.println(l + "条");
        for (User i : mapper.selectLimitBySelective(user, ((3 - 1) * 10), 10)) {
            System.out.println(i);
        }
    }

}
