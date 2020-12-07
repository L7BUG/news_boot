package com.l.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    /**
     * 评论id
     */
    private Integer id;

    /**
     * 新闻id
     */
    private New mNew;

    /**
     * 用户id
     */
    private User user;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间 默认为 当前时间
     */
    private Date publishTime;
}