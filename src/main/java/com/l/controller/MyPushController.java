package com.l.controller;

import com.l.json.MyJSON;
import com.l.pojo.New;
import com.l.requestUrl.POST;
import com.l.service.NewService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyPushController {
    @Autowired
    private NewService newService;

    @PostMapping(POST.QUERY_NEW)
    public MyJSON<List<New>> query(@RequestBody New request) {
        MyJSON<List<New>> resp = null;
        try {
            newService.setPageShowNumber(Integer.MAX_VALUE);
            List<New> page = newService.getPage(request, 1);
            resp = RespJsonUtils.get(page, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }
}
