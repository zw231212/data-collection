package com.nstr.data.collection.schedule;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.model.pojo.HistoryComment;
import com.nstr.data.collection.service.BackupCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HistoryCommentTask {

    private static final Logger logger = LoggerFactory.getLogger(HistoryCommentTask.class);

    private static final String SCHEDULE_WEEK_CRON = "0 0 1 ? * L";//  每周星期天凌晨1点实行一次
    private static final String SCHEDULE_MONTH_CRON = "0 0 1 1 * ?";//每月1号凌晨1点执行一次
    private static final String SCHEDULE_CRON = "week".equals(AppConstant.BACKUP_TYPE)?SCHEDULE_WEEK_CRON:SCHEDULE_MONTH_CRON;

    @Resource
    private BackupCommentService backupCommentService;

    @Scheduled(cron = SCHEDULE_MONTH_CRON)
    public void backupHistoryCommentData(){//将历史数据进行备份到新表，并删除原来的
        logger.info("定时备份整理评论数据:"+SCHEDULE_CRON);
        backupCommentService.backup();
    }

}
