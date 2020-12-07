package com.l;

import com.l.pojo.Comment;
import com.l.pojo.New;
import com.l.pojo.User;
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
        Comment comment = new Comment();
        User user = new User();
        New n = new New();
        n.setId(8);
        comment.setContent("b");
        comment.setMNew(n);
        mapper.setPageShowNumber(5);
        for (Comment i : mapper.getPage(comment, 2)) {
            System.err.println(i);
        }
        System.out.println(mapper.selectSelectiveCount(comment));
    }

}
