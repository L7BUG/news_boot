package com.l.service;

import com.l.pojo.Category;

import java.util.List;


public interface CategoryService {
    /**
     * 根据 主键查询单个
     *
     * @param integer
     * @return
     */
    Category selectByPrimaryKey(Integer integer);

    /**
     * 查询所有
     *
     * @return
     */
    List<Category> selectAll();

    /**
     * 插入一条数据 返回 id 给 category
     *
     * @param category
     * @return
     */
    int insertOne(Category category);

    /**
     * 根据主键删除一条信息
     *
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键更新一条数据
     *
     * @return
     */
    int updateByPrimaryKey(Category category);
}
