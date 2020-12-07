package com.l.service;

import com.l.pojo.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 查询所有评论
     *
     * @return
     */
    List<Comment> selectAll();

    /**
     * 根据主键查询一条评论
     *
     * @param id
     * @return
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     * 添加一条信息
     *
     * @param comment content newId 为必填项目
     * @return
     */
    int insertOne(Comment comment);

    /**
     * 动态条件删除信息
     * id, newId 通过 and 拼接
     *
     * @return
     */
    int deleteBySelective(Comment comment);

    /**
     * 根据主键动态修改信息
     *
     * @param comment
     * @return
     */
    int updateByPrimaryKeySelective(Comment comment);

    /**
     * 分页动态查询 content 查询为 like 条件
     *
     * @param comment
     * @param index
     * @param number
     * @return
     */
    List<Comment> selectLimitBySelective(Comment comment, int index, int number);

    /**
     * 获取动态条件查询的数量
     *
     * @param comment
     * @return
     */
    long selectSelectiveCount(Comment comment);

    /**
     * 获取某一页
     *
     * @param comment 查询条件
     * @param page
     * @return
     */
    List<Comment> getPage(Comment comment, int page);

    /**
     * 设置每页数量
     *
     * @param number
     */
    default void setPageShowNumber(int number) {

    }

    //    返回每页显示数量
    default int getPageShowNumber() {
        return 10;
    }
}
