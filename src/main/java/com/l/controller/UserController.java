package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
public class UserController {
    @PostMapping("/checkUser")
    public String loginAdmin(@RequestBody String jsonStr){
        System.out.println();
        JSONObject resp = new JSONObject();
        return resp.toString();
    }
}
