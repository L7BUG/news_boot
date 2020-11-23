package com.l.mapper;

import com.l.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper {
    int deleteById(Integer roleId);

    int insertOne(Role record);

    Role selectById(Integer roleId);

    int updateById(Role record);
}