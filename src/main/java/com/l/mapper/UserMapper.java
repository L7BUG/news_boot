package com.l.mapper;

import com.l.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 动态条件条件查询
     *
     * @param user 用于设置参数
     * @return
     */
    List<User> selectBySelective(User user);

    /**
     * 插入一条数据
     *
     * @param user username password 为必填项目
     * @return
     */
    int insertOne(User user);

    /**
     * 动态条件查询
     *
     * @param user
     * @return
     */
    int deleteBySelective(User user);

    /**
     * 根据id修改用户信息     *
     *
     * @param user id 为 必填项目
     * @return
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 分页动态查询 username 查询为 like 条件
     *
     * @param user
     * @param index  从哪里开始
     * @param number 数量
     * @return
     */
    List<User> selectLimitBySelective(@Param("user") User user, @Param("index") Integer index, @Param("number") Integer number);

    /**
     * 动态条件获取数量
     *
     * @param user
     * @return
     */
    long selectSelectiveCount(User user);
}
