package com.l;

import com.l.mapper.CommentMapper;
import com.l.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    CommentMapper mapper;

    @Test
    void contextLoads() {
        Comment comment = mapper.selectByPrimaryKey(3);
        comment.setContent("该死的评论");
        mapper.updateByPrimaryKeySelective(comment);
    }
}
