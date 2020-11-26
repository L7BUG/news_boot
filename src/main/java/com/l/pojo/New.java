package com.l.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * New
 */
@Data
public class New implements Serializable {
    /**
     * 新闻id
     */
    private Integer id;

    /**
     * 信息标题
     */
    private String title;

    /**
     * 信息内容
     */
    private String content;

    /**
     * 信息类别ID
     */
    private Category category;

    /**
     * 发布用户ID
     */
    private User user;

    /**
     * 发布时间 默认为 当前时间
     */
    private Date publishTime;

    /**
     * 浏览次数
     */
    private Integer clicks;

    /**
     * 状态 1: 发布 2: 待删除
     */
    private String publishStatus;
    /**
     * 评论
     */
    private List<Comment> comments;
}