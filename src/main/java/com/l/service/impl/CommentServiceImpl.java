package com.l.service.impl;

import com.l.mapper.CommentMapper;
import com.l.pojo.Comment;
import com.l.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Override
    public List<Comment> selectLimitBySelective(Comment comment, int index, int number) {
        return commentMapper.selectLimitBySelective(comment, index, number);
    }

    @Override
    public long selectSelectiveCount(Comment comment) {
        return commentMapper.selectSelectiveCount(comment);
    }

    @Override
    public List<Comment> getPage(Comment comment, int page) {
        return selectLimitBySelective(comment, (page - 1) * this.pageShowNumber, this.pageShowNumber);
    }

    @Value("10")
    private int pageShowNumber;

    @Override
    public void setPageShowNumber(int number) {
        this.pageShowNumber = number;
    }

    @Override
    public int getPageShowNumber() {
        return this.pageShowNumber;
    }
}
