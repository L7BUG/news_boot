package com.l.controller;

import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.Role;
import com.l.service.RoleService;
import com.l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class AdminSystemController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping("/queryAll")
    public MyJSON<List<Role>> selectAll() {
        MyJSON<List<Role>> resp = new MyJSON<>();
        try {
            List<Role> list = roleService.selectAll();
            resp.setCode(CODE.OK);
            resp.setMessage(MESSAGE.OK);
            resp.setData(list);
        } catch (Exception e) {
            resp.setCode(CODE.ERROR);
            resp.setMessage(MESSAGE.ERROR);
        } finally {
            return resp;
        }
    }

    @PostMapping("/add")
    public MyJSON<Void> addRole(@RequestBody Role role) {
        MyJSON<Void> voidMyJSON = new MyJSON<>();
        try {
            roleService.insertOne(role);
            voidMyJSON.setCode(CODE.OK);
            voidMyJSON.setMessage(MESSAGE.OK);
        } catch (Exception e) {
            voidMyJSON.setCode(CODE.ERROR);
            voidMyJSON.setMessage(MESSAGE.ERROR);
        } finally {
            return voidMyJSON;
        }
    }
}
