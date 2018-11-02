package com.nstr.data.collection.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyExample;
import com.nstr.data.collection.repository.DailyMapper;
import com.nstr.data.collection.service.DailyService;
import com.nstr.data.collection.util.ServiceUtil;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DailyServiceImpl implements DailyService {

    @Resource
    private DailyMapper dailyMapper;

    @Override
    public PageInfo<Daily> findAll(List<String> dates, Integer number, Integer size, String type, String sort) {
        dates = ServiceUtil.checkDates(dates);
        if(number < 0){
            number = 0;
        }
        if(size < 0){
            size = 10;
        }
        if(StringUtil.isNullOrBlank(sort)){
            sort = "value DESC";
        }

        DailyExample example = new DailyExample();
        example.setOrderByClause(sort);
        DailyExample.Criteria criteria = example.createCriteria();
        switch (type){
            case "day":
                criteria.andDayIn(dates);
                break;
            case "month":
                criteria = example.or();
                for (String date : dates) {
                    criteria.andDayLike(date+"%");
                }
                break;
            case "year":
                criteria = example.or();
                for (String date : dates) {
                    criteria.andDayLike(date+"%");
                }
                break;
        }
        PageHelper.startPage(number, size);

        List<Daily> dailies = dailyMapper.selectByExample(example);
        return new PageInfo<>(dailies);
    }
}
