package com.l.controller;

import com.l.service.RoleService;
import com.l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class AdminSystemController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    

}
