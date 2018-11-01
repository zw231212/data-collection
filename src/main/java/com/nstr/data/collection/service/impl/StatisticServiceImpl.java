package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.repository.DailyMapper;
import com.nstr.data.collection.repository.StatisticMapper;
import com.nstr.data.collection.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;
    @Resource
    private DailyMapper dailyMapper;


    @Override
    public void dailyStatistic() {

    }
}
