package com.l;

import com.l.mapper.NewMapper;
import com.l.pojo.Category;
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
        New n = new New();
        Category category = new Category();
        category.setId(1);
        n.setCategory(category);
        long l = mapper.selectSelectiveCount(n);
        System.out.println(l);
        for (long i = 1; i <= l / 5 + 1; i++) {
            List<New> news = mapper.selectLimitBySelective(n, (int) ((i - 1) * 5), 5);
            for (New j : news) {
                System.out.println(j);
            }
        }
    }

}
