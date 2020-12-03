package com.l;

import com.l.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    CommentMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.selectByPrimaryKey(1));
    }

}
