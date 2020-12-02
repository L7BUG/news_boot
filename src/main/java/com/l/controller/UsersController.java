package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MyJSON;
import com.l.pojo.User;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.POST;
import com.l.requestUrl.PUT;
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

    /**
     * 删除单个
     *
     * @param id
     * @return
     */
    @DeleteMapping(DELETE.DELETE_USER + "/{id}")
    public MyJSON<Void> deleteOne(@PathVariable int id) {
        MyJSON<Void> respData = null;
        try {
            User user = new User();
            user.setId(id);
            userService.deleteBySelective(user);
            respData = RespJsonUtils.get(CODE.OK, "删除成功", null);
        } catch (Exception e) {
            respData = RespJsonUtils.get(CODE.ERROR, "因为约束关系无法删除！处理约束关系后继续！", null);
        } finally {
            return respData;
        }
    }

    /**
     * 删除多个用户
     *
     * @param request
     * @return
     */
    @PostMapping(DELETE.DELETE_USER)
    public MyJSON<Void> deleteArr(@RequestBody List<User> request) {
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (User user : request) {
            try {
                userService.deleteBySelective(user);
                sb.append(user.getId() + "<p>成功</p>");
                flag = false;
            } catch (Exception e) {
                sb.append(user.getId() + "<p>失败</p>");
            }
        }
//        一个也没删除
        if (flag) {
            return RespJsonUtils.get(CODE.ERROR, "<h4>删除失败!请处理相关约束</h4>" + sb.toString(), null);
        }
//        全部删除完毕
        if (sb.equals("")) {
            return RespJsonUtils.get(CODE.OK, "<h4>删除成功</h4>", null);
        }
//        删除部分
        return RespJsonUtils.get(CODE.OK, "<h4>部分资源因为约束关系删除失败！</h4>"
                + sb.toString() + "<h4  >请处理约束关系</h4    >", null);
    }

    @PostMapping(POST.ADD_USER)
    public MyJSON<Void> addUser(@RequestBody User request) {
        MyJSON<Void> resp = null;
        try {
            userService.insertOne(request);
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, "新增失败!", null);
        } finally {
            return resp;
        }
    }

    @PutMapping(PUT.UPDATE_USER)
    public MyJSON<Void> updateUser(@RequestBody User request) {
        MyJSON<Void> resp = null;
        try {
            userService.updateByPrimaryKeySelective(request);
            resp = RespJsonUtils.get(CODE.OK, "更新成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }
}
