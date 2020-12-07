package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.MyJSON;
import com.l.pojo.Comment;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.POST;
import com.l.requestUrl.PUT;
import com.l.service.CommentService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(POST.QUERY_COMMENT + "/{page}")
    public MyJSON<JSONObject> getPage(@RequestBody JSONObject request, @PathVariable("page") int page) {
        MyJSON<JSONObject> resp = null;
        try {
//        查询条件
            Comment comment = request.toJavaObject(Comment.class);
//        显示个数
            Integer pageShowNumber = request.getInteger("pageShowNumber");
            commentService.setPageShowNumber(pageShowNumber);
            JSONObject respData = new JSONObject();
            List<Comment> dataList = commentService.getPage(comment, page);
//            总数
            long maxPageNumber = commentService.selectSelectiveCount(comment);
            respData.put("data", dataList);
            respData.put("maxPageNumber", maxPageNumber);
            resp = RespJsonUtils.get(respData, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @PostMapping(POST.ADD_COMMENT)
    public MyJSON<Void> addComment(@RequestBody JSONObject request) {
        MyJSON<Void> resp = null;
        try {
            Comment comment = request.toJavaObject(Comment.class);
            commentService.insertOne(comment);
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @PutMapping(PUT.UPDATE_COMMENT)
    public MyJSON<Void> updateComment(@RequestBody JSONObject request) {
        System.out.println("request = " + request);
        MyJSON<Void> resp = null;
        try {
            Comment comment = request.toJavaObject(Comment.class);
            commentService.updateByPrimaryKeySelective(comment);
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @DeleteMapping(DELETE.DELETE_COMMENT + "/{id}")
    public MyJSON<Void> deleteComment(@PathVariable("id") int id) {
        MyJSON<Void> resp = null;
        try {
            Comment comment = new Comment();
            comment.setId(id);
            commentService.deleteBySelective(comment);
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @DeleteMapping(DELETE.DELETE_COMMENT)
    public MyJSON<Void> deleteComment(@RequestBody List<Comment> request) {
        System.out.println(request);
        MyJSON<Void> resp = null;
        try {
            for (Comment comment : request) {
                commentService.deleteBySelective(comment);
            }
            resp = RespJsonUtils.get(null, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }
}
