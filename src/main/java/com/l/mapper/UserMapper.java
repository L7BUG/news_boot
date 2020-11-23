package com.l.mapper;

import com.l.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    int deleteById(Integer userId);

    int insertSelective(User record);

    User selectById(Integer userId);

    int updateByIdSelective(User record);

    User selectByName(String name);
}