package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/api/test")
    public String test(@RequestBody JSONObject body) {
        System.out.println(body.toString());
        return "{a: 123, b: 321}";
    }
}
