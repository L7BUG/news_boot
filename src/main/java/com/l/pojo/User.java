package com.l.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 角色ID
     */
    private Role roleId;

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