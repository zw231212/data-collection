package com.nstr.data.collection.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyStatisticTask {

    @Scheduled(cron = "0/5 * *  * * ? ")   //每5秒执行一次
    public void dailyStatistic(){//将历史数据进行备份到新表，并删除原来的
        System.out.println("进入测试");
    }

}
