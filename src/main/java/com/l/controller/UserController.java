package com.l.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
public class UserController {
    @PostMapping("/checkUser")
    public String loginAdmin(@RequestBody String jsonStr){
        User user = JSON.parseObject(jsonStr, User.class);
        JSONObject resp = new JSONObject();
        if (user.equals(new User("admin", "123456"))) {
            resp.put("code", CODE.OK);
            resp.put("message", MESSAGE.OK);
            resp.put("data", user);
        }else {
            resp.put("code", CODE.ERROR);
            resp.put("message", MESSAGE.ERROR);
        }
        return resp.toString();
    }
    @PostMapping("/test")
    public String test(@RequestBody String string){
        System.out.println(string);
        return "ok";
    }

    @PostMapping("/postJSON")
    public String postJSON(@RequestBody String json){
        User user = JSON.parseObject(json, User.class);
        System.out.println(user);
        return "傻逼CSDN";
    }
}
