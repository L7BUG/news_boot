package com.l;

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
        System.out.println(service.selectAll());
    }
}
