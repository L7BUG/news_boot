package com.l;

import com.l.mapper.CommentMapper;
import com.l.pojo.Comment;
import com.l.pojo.New;
import com.l.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    CommentMapper mapper;

    @Test
    void contextLoads() {
        Comment comment = new Comment();
        User user = new User();
        New n = new New();
        n.setId(8);
        comment.setContent("b");
        comment.setMNew(n);
        for (Comment i : mapper.selectLimitBySelective(comment, 0, 10)) {
            System.err.println(i);
        }
        System.out.println(mapper.selectSelectiveCount(comment));
    }

}
