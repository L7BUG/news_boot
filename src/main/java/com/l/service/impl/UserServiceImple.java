package com.l.service.impl;

import com.l.mapper.UserMapper;
import com.l.pojo.User;
import com.l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Override
    public List<User> selectLimitBySelective(User user, Integer index, Integer number) {
        return userMapper.selectLimitBySelective(user, index, number);
    }

    @Override
    public long selectSelectiveCount(User user) {
        return userMapper.selectSelectiveCount(user);
    }

    @Override
    public List<User> getPage(User user, int page) {
        return userMapper.selectLimitBySelective(user, ((page - 1) * pageShowNumber), pageShowNumber);
    }

    @Value("10")
    private int pageShowNumber;


    public void setPageShowNumber(int number) {
        this.pageShowNumber = number;
    }

    @Override
    public int getPageShowNumber() {
        return this.pageShowNumber;
    }
}
