package com.l.pojo;

import lombok.Data;

import java.io.Serializable;

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
     * 评论内容
     */
    private String content;
}