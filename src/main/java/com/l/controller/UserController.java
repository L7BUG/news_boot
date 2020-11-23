package com.l.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.l.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping(value = "/api/admin")
public class UserController {
    @PostMapping("/checkUser")
    public String loginAdmin(@RequestBody String jsonStr){
        System.out.println();
        JSONObject resp = new JSONObject();
        return resp.toString();
    }

    @PostMapping("/postJSON")
    public String postJSON(@RequestBody String json){
        System.out.println(json);
        User user = JSON.parseObject(json, User.class);
        System.out.println(user);
        return "傻逼CSDN";
    }

    @PostMapping("/test")
    public User test(@RequestBody String t, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s + "===>" + request.getHeader(s));
        }
        User user = JSON.parseObject(t, User.class);
        System.out.println(user);
        return user;
    }
}
