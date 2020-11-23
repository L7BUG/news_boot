package com.l.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 登陆账号
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 注册状态 1:未启用 2: 启用 3: 被禁用
     */
    private Integer status;
}