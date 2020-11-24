package com.l.mapper;

import com.l.pojo.Role;
import com.l.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> selectAll();

    Role selectRoleById(Integer id);
}
