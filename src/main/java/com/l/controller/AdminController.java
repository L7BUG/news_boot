package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.User;
import com.l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/query")
    public MyJSON<User> loginAdmin(@RequestBody JSONObject jsonStr) {
        User selective = jsonStr.toJavaObject(User.class);
        List<User> result = userService.selectBySelective(selective);
        MyJSON<User> data = new MyJSON<>();
        if (result.size() > 0) {
            data.setCode(CODE.OK);
            data.setMessage(MESSAGE.OK);
            data.setData(result.get(0));
        } else {
            data.setCode(CODE.ERROR);
            data.setMessage(MESSAGE.ERROR);
        }
        return data;
    }
}
