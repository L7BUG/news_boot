package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.Comment;
import com.l.pojo.New;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.POST;
import com.l.requestUrl.PUT;
import com.l.service.CommentService;
import com.l.service.NewService;
import com.l.service.UserService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewController {
    @Autowired
    private NewService newService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping(POST.QUERY_NEW + "/{page}")
    public MyJSON<JSONObject> getPage(@RequestBody JSONObject request, @PathVariable("page") int page) {
        MyJSON<JSONObject> resp = null;
        try {
//            查询条件
            New n = request.toJavaObject(New.class);
            System.out.println(n);
//            每页显示数量
            Integer pageShowNumber = request.getInteger("pageShowNumber");
            newService.setPageShowNumber(pageShowNumber);
            JSONObject jsonObject = new JSONObject();
//            总数
            long maxPageNumber = newService.selectSelectiveCount(n);
            List<New> data = newService.getPage(n, page);
            jsonObject.put("maxPageNumber", maxPageNumber);
            jsonObject.put("data", data);
            resp = RespJsonUtils.get(CODE.OK, MESSAGE.OK, jsonObject);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @DeleteMapping(DELETE.DELETE_NEW + "/{id}")
    public MyJSON<Void> deleteOne(@PathVariable("id") int id) {
        MyJSON<Void> resp = null;
        try {
            New n = new New();
            n.setId(id);
            Comment comment = new Comment();
            comment.setMNew(n);
            commentService.deleteBySelective(comment);
            newService.deleteBySelective(n);
            resp = RespJsonUtils.get(CODE.OK, "删除成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, MESSAGE.ERROR, null);
            e.printStackTrace();
        } finally {
            return resp;
        }
    }

    @DeleteMapping(DELETE.DELETE_NEW)
    public MyJSON<Void> deleteNews(@RequestBody List<New> request) {
        MyJSON<Void> resp = null;
        try {
            for (New n : request) {
                Comment comment = new Comment();
                comment.setMNew(n);
                commentService.deleteBySelective(comment);
                newService.deleteBySelective(n);
            }
            resp = RespJsonUtils.get(CODE.OK, "删除成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, MESSAGE.ERROR, null);
            e.printStackTrace();
        } finally {
            return resp;
        }
    }

    @PostMapping(POST.ADD_NEW)
    public MyJSON<Void> addNew(@RequestBody New n) {
        MyJSON<Void> resp = null;
        try {
            if (userService.selectByPrimaryKey(n.getUser().getId()) == null) {
                resp = RespJsonUtils.get(CODE.ERROR, "未找到该用户!", null);
            } else {
                newService.insertOne(n);
                resp = RespJsonUtils.get(CODE.OK, "新增成功", null);
            }
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @PutMapping(PUT.UPDATE_NEW)
    public MyJSON<Void> updateNew(@RequestBody New n) {
        System.out.println(n);
        MyJSON<Void> resp = null;
        try {
            newService.updateByPrimaryKeySelective(n);
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }
}
