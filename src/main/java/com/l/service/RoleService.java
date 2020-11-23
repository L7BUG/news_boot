package com.l.service;

import com.l.pojo.Role;

public interface RoleService {
    int deleteById(Integer roleId);

    int insertOne(Role record);

    int insertSelective(Role record);

    Role selectById(Integer roleId);

    int updateByIdSelective(Role record);

    int updateById(Role record);
}
