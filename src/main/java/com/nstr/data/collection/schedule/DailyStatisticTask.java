package com.nstr.data.collection.schedule;

import com.nstr.data.collection.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DailyStatisticTask {

    private static final Logger logger = LoggerFactory.getLogger(HistoryCommentTask.class);

    private static final String SCHEDULE_CRON = "0/5 * *  * * ? ";//0/5 * *  * * ? 每5秒执行一次，0 0 0 * * ? *，每天执行一次

    @Resource
    private StatisticService statisticService;

    @Scheduled(cron = SCHEDULE_CRON)   //每5秒执行一次
    public void dailyStatistic(){//将历史数据进行备份到新表，并删除原来的
        logger.info("每日统计昨天数据（包括基本的数据，以及每列的统计以及评论内容的分词统计）:"+SCHEDULE_CRON);
        statisticService.dailyStatistic();
        statisticService.dailyCommentStatistic();
    }

}
