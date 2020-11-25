package com.l;

import com.l.mapper.NewMapper;
import com.l.pojo.New;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewsBootApplicationTests {
    @Autowired
    NewMapper mapper;

    @Test
    void contextLoads() {
        List<New> o = mapper.selectByPrimaryKey(1);
        for (New i : o) {
            System.out.println(i.getCategory());
            System.out.println(i.getUser());
            System.out.println(i);
        }

    }
}
