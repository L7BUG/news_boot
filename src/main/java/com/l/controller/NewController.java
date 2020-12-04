package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;
import com.l.pojo.New;
import com.l.requestUrl.POST;
import com.l.service.NewService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewController {
    @Autowired
    private NewService newService;

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
}
