package com.l.mapper;

import com.l.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
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
}
