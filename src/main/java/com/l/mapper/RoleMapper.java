package com.l.mapper;

import com.l.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    /**
     * 查询 所有角色
     *
     * @return 返回一个List
     */
    List<Role> selectAll();

    /**
     * 根据 id 查询对应的权限
     *
     * @param id 传入 id
     * @return
     */
    Role selectById(Integer id);

    /**
     * 删除一个角色
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 插入一条角色信息 并返回主键给实体类
     *
     * @param role role.id == null
     * @return 返回sql执行结果
     */
    int insertOne(Role role);

    /**
     * 更新角色信息
     *
     * @param role
     * @return 返回 sql 执行结果
     */
    int updateOne(Role role);
}
