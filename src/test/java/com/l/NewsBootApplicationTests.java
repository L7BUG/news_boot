package com.l;

import com.l.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    CommentService mapper;

    @Test
    void contextLoads() {
        System.err.println(mapper.selectAll().get(0));
    }

}
