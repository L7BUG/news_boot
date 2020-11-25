package com.l.mapper;

import com.l.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CategoryMapper {
    Category selectByPrimaryKey(Integer integer);

    Category selectByPrimaryKeyOrNews(Integer integer);
}
