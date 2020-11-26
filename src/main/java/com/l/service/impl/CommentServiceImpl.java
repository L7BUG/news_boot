package com.l.service.impl;

import com.l.mapper.CommentMapper;
import com.l.pojo.Comment;
import com.l.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertOne(Comment comment) {
        return commentMapper.insertOne(comment);
    }

    @Override
    public int deleteBySelective(Comment comment) {
        return commentMapper.deleteBySelective(comment);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
