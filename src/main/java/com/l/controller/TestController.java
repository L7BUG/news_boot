package com.l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @PostMapping("/api/test")
    @ResponseBody
    public String test(String s){
        System.out.println(s);
        System.out.println("没有热水");
        return "{a: 123, b: 321}";
    }
}
