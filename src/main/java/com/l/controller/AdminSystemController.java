package com.l.controller;

import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.Role;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.GET;
import com.l.requestUrl.POST;
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
            voidMyJSON = RespJsonUtils.get(CODE.ERROR, MESSAGE.ERROR);
        } finally {
            return voidMyJSON;
        }
    }

    @DeleteMapping(DELETE.DELETE_ROLE + "/{id}")
    public MyJSON<Void> deleteRole(@PathVariable int id) {
        System.out.println(id);
        MyJSON<Void> resp = new MyJSON<>();
        return resp;
    }
}
