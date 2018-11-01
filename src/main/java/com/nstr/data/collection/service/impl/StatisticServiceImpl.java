package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.repository.DailyColumnMapper;
import com.nstr.data.collection.repository.DailyMapper;
import com.nstr.data.collection.repository.StatisticMapper;
import com.nstr.data.collection.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;
    @Resource
    private DailyColumnMapper dailyColumnMapper;


    @Override
    public void dailyStatistic() {
        List<String> scs = AppConstant.statisticColumns;
        for (String sc : scs) {
            List<DailyColumn> columns = statisticMapper.columnStatic(sc);
            dailyColumnMapper.insertBatchSelective(columns);
        }
    }
}
