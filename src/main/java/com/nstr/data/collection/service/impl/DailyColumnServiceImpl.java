package com.nstr.data.collection.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.model.pojo.DailyColumnExample;
import com.nstr.data.collection.repository.DailyColumnMapper;
import com.nstr.data.collection.repository.DailyCommentMapper;
import com.nstr.data.collection.service.DailyColumnService;
import com.nstr.data.collection.util.ServiceUtil;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyColumnServiceImpl implements DailyColumnService {

    @Resource
    private DailyColumnMapper dailyColumnMapper;

    @Override
    public PageInfo<DailyColumn> findAll(List<String> dates, Integer number, Integer size,
                                         String type, String sort, List<String> columns) {
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

        DailyColumnExample example = new DailyColumnExample();
        example.setOrderByClause(sort);
        DailyColumnExample.Criteria criteria = example.createCriteria();
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

        if(columns != null&& columns.size() >0){
            criteria.andTypeIn(columns);
        }

        PageHelper.startPage(number, size);

        List<DailyColumn> dailyColumns = dailyColumnMapper.selectByExample(example);

        return new PageInfo<>(dailyColumns);
    }
}
