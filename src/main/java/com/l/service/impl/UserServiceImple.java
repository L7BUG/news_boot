package com.l.service.impl;

import com.l.mapper.UserMapper;
import com.l.pojo.User;
import com.l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectBySelective(User user) {
        return userMapper.selectBySelective(user);
    }

    @Override
    public int insertOne(User user) {
        return userMapper.insertOne(user);
    }

    @Override
    public int deleteBySelective(User user) {
        return userMapper.deleteBySelective(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
