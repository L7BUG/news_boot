package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.User;
import com.l.service.UserService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/query")
    public MyJSON<User> loginAdmin(@RequestBody JSONObject jsonStr) {
        User selective = jsonStr.toJavaObject(User.class);
        List<User> result = userService.selectBySelective(selective);
        MyJSON<User> data = null;
        if (result.size() > 0) {
            return RespJsonUtils.get(CODE.OK, MESSAGE.OK, result.get(0));
        } else {
            return RespJsonUtils.get(CODE.ERROR, MESSAGE.ERROR, null);
        }
    }
}
