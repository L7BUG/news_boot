package com.l;

import com.l.json.MESSAGE;
import com.l.service.RoleService;
import com.l.utils.RespJsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    RoleService service;

    @Test
    void contextLoads() {
        System.out.println(RespJsonUtils.get(null, MESSAGE.OK, new ArrayList()));
    }

}
