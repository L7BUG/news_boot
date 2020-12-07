package com.l;

import com.l.mapper.*;
import com.l.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class DataBaseInit {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private NewMapper newMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void init() {
        userInit();
        newInit();
        commentInit();
    }

    private void userInit() {
        Role role = roleMapper.selectById(2);
        User user = new User();
        user.setRole(role);
        for (int i = 1; i <= 100; i++) {
            user.setUsername("测试用户" + UUID.randomUUID().toString().substring(0, 5));
            user.setPassword("123456");
            userMapper.insertOne(user);
        }
    }

    private void newInit() {
        Random random = new Random();
        List<User> userList = userMapper.selectAll();
        List<Category> categories = categoryMapper.selectAll();
        New t = new New();
        for (int i = 0; i < 100; i++) {
            User user = userList.get(random.nextInt(userList.size()));
            Category category = categories.get(random.nextInt(categories.size()));
            t.setCategory(category);
            t.setUser(user);
            t.setTitle("测试新闻" + UUID.randomUUID().toString().substring(0, 5));
            t.setContent(UUID.randomUUID().toString() + "这是新闻主体");
            newMapper.insertOne(t);
        }
    }

    private void commentInit() {
        List<New> news = newMapper.selectAll();
        List<User> users = userMapper.selectAll();
        Random random = new Random();
        Comment comment = new Comment();
        for (int i = 0; i < 1000; i++) {
            New aNew = news.get(random.nextInt(news.size()));
            User user = users.get(random.nextInt(users.size()));
            comment.setUser(user);
            comment.setMNew(aNew);
            comment.setContent(UUID.randomUUID().toString());
            commentMapper.insertOne(comment);
        }
    }
}
