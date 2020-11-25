package com.l.mapper;

import com.l.pojo.New;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewMapper {
    List<New> selectByPrimaryKey(Integer id);
}
