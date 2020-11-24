package com.l.mapper;

import com.l.pojo.A;
import com.l.pojo.B;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BMapper {
    List<B> b();

    A a(Integer id);
}
