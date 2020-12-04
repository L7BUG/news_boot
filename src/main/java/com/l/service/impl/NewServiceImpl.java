package com.l.service.impl;

import com.l.mapper.NewMapper;
import com.l.pojo.New;
import com.l.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newService")
public class NewServiceImpl implements NewService {
    @Autowired
    private NewMapper newMapper;

    @Override
    public New selectByPrimaryKey(Integer id) {
        return newMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<New> selectAll() {
        return newMapper.selectAll();
    }

    @Override
    public int insertOne(New t) {
        return newMapper.insertOne(t);
    }

    @Override
    public int deleteBySelective(New t) {
        return newMapper.deleteBySelective(t);
    }

    @Override
    public int updateByPrimaryKeySelective(New t) {
        return newMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKeyAddClicks(Integer id) {
        return newMapper.updateByPrimaryKeyAddClicks(id);
    }

    @Override
    public List<New> selectLimitBySelective(New n, Integer index, Integer number) {
        return newMapper.selectLimitBySelective(n, index, number);
    }

    @Override
    public long selectSelectiveCount(New n) {
        return newMapper.selectSelectiveCount(n);
    }

    @Override
    public List<New> getPage(New n, int page) {
        return selectLimitBySelective(n
                , (page - 1) * getPageShowNumber()
                , getPageShowNumber());
    }

    @Value("10")
    private int pageShowNumber;

    @Override
    public void setPageShowNumber(int number) {
        this.pageShowNumber = number;
    }

    @Override
    public int getPageShowNumber() {
        return pageShowNumber;
    }
}
