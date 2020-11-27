package com.l.controller;

import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.Role;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.GET;
import com.l.requestUrl.POST;
import com.l.requestUrl.PUT;
import com.l.service.RoleService;
import com.l.service.UserService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminSystemController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping(GET.QUERY_ALL_ROLE)
    public MyJSON<List<Role>> selectAll() {
        MyJSON<List<Role>> resp = null;
        try {
            List<Role> list = roleService.selectAll();
            resp = RespJsonUtils.get(CODE.OK, MESSAGE.OK, list);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.OK, MESSAGE.OK, null);
        } finally {
            return resp;
        }
    }

    @PostMapping(POST.ADD_ROLE)
    public MyJSON<Void> addRole(@RequestBody Role role) {
        MyJSON<Void> voidMyJSON = null;
        try {
            roleService.insertOne(role);
            voidMyJSON = RespJsonUtils.get(CODE.OK, MESSAGE.OK);
        } catch (Exception e) {
            voidMyJSON = RespJsonUtils.get(CODE.ERROR, "角色名称必须唯一");
        } finally {
            return voidMyJSON;
        }
    }

    @DeleteMapping(DELETE.DELETE_ROLE + "/{id}")
    public MyJSON<Void> deleteRole(@PathVariable int id) {
        MyJSON<Void> resp = null;
        try {
            int i = roleService.deleteById(id);
            if (i > 0) {
                resp = RespJsonUtils.get(null, true);
            } else {
                resp = RespJsonUtils.get(null, false);
            }
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, "该角色因为约束关系无法删除！处理约束关系后再重试！");
        } finally {
            return resp;
        }
    }

    @PutMapping(PUT.UPDATE_ROLE)
    public MyJSON<Void> updateRole(@RequestBody Role role) {
        MyJSON<Void> resp = null;
        try {
            roleService.updateOne(role);
            resp = RespJsonUtils.get(CODE.OK, MESSAGE.OK);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, "更新失败");
            e.printStackTrace();
        } finally {
            return resp;
        }
    }
}
