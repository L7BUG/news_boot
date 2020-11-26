package com.l;

import com.l.pojo.Role;
import com.l.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    RoleService service;

    @Test
    void contextLoads() {
        System.out.println(service.insertOne(new Role(null, "test事务", "test事务")));
    }
}
