package com.l.service.impl;

import com.l.mapper.RoleMapper;
import com.l.pojo.Role;
import com.l.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int insertOne(Role role) {
        int i = roleMapper.insertOne(role);
        return i;
    }

    @Override
    public int updateOne(Role role) {
        return roleMapper.updateOne(role);
    }
}
