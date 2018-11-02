package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.repository.DailyColumnMapper;
import com.nstr.data.collection.repository.DailyMapper;
import com.nstr.data.collection.repository.StatisticMapper;
import com.nstr.data.collection.service.StatisticService;
import com.nstr.data.collection.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;
    @Resource
    private DailyColumnMapper dailyColumnMapper;
    @Resource
    private DailyMapper dailyMapper;


    @Override
    public void dailyStatistic() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        List<String> scs = AppConstant.statisticColumns;
        Long[] bes = DateUtil.getLongTypeBeginAndEnd("day",year,month,day);
        List<Daily> dailies = statisticMapper.commonStatic(bes[0], bes[1]);
        if(dailies != null && dailies.size() > 0){
            //先删除相同的数据
            statisticMapper.deleteSameDayData(AppConstant.DAILY_TABLE,
                    DateUtil.getFormerDate(year+""+month+""+day,"yyyyMMdd")
            );
            dailyMapper.insertBatch(dailies);
        }
        for (String sc : scs) {
            List<DailyColumn> columns = statisticMapper.columnStatic(sc,bes[0], bes[1]);
            if(columns == null || columns.size() ==0 ){
                continue;
            }
            statisticMapper.deleteSameDayDataByType(AppConstant.DAILY_COLUMN_TABLE,
                    DateUtil.getFormerDate(year+""+month+""+day,"yyyyMMdd"),
                    sc);
            dailyColumnMapper.insertBatch(columns);
        }
    }
}
