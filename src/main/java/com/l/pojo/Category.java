package com.l.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类别表
 */
@Data
public class Category implements Serializable {
    /**
     * 类别ID
     */
    private Integer id;

    /**
     * 类别名称
     */
    private String name;
    /**
     * 新闻列表
     */
    private List<New> news;
}