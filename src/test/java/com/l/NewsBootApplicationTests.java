package com.l;

import com.l.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    RoleMapper roleMapper;
    @Test
    void contextLoads() {
        System.out.println(roleMapper.selectById(1));
    }

}
