package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.MyJSON;
import com.l.pojo.User;
import com.l.requestUrl.POST;
import com.l.service.UserService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理controller
 */
@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping(POST.QUERY_USER + "/{page}")
    public MyJSON<JSONObject> getAll(@RequestBody JSONObject jsonObject, @PathVariable int page) {
        MyJSON<JSONObject> resp = null;
        try {
//        前端传递过来的显示数量
            Integer pageShowNumber = jsonObject.getInteger("pageShowNumber");
//        设置查询数量
            userService.setPageShowNumber(pageShowNumber);
//        前端传递的查询条件
            User user = jsonObject.toJavaObject(User.class);
            JSONObject respData = new JSONObject();
//        该条件的总条目
            respData.put("maxPageNumber", userService.selectSelectiveCount(user));
            List<User> tableData = userService.getPage(user, page);
            respData.put("tableData", tableData);
            resp = RespJsonUtils.get(respData, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }
}
