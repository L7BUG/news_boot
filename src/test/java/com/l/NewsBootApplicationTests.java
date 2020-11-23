package com.l;

import com.l.mapper.RoleMapper;
import com.l.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    RoleMapper roleMapper;

    @Test
    void contextLoads() {
        Role role = roleMapper.selectById(1);
        role.setName("admin");
        System.out.println(roleMapper.updateOne(role));
    }
}
