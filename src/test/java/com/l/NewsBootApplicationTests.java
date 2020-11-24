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
        User temp = new User();
        Role role = new Role();
        role.setId(1);
        temp.setRole(role);
        User user = mapper.selectBySelective(temp).get(1);
        user.setUsername("lllYY");
        user.setPassword("112233");
        System.out.println(mapper.updateByPrimaryKeySelective(user));

    }
}
