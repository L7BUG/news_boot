package com.l;

import com.l.mapper.BMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    BMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.a(1));
        System.out.println(mapper.b());
    }
}
