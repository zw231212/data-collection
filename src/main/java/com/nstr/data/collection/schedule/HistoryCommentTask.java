package com.nstr.data.collection.schedule;

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

    private static final String SCHEDULE_CRON = "0/5 * *  * * ? ";//每5秒执行一次

    @Resource
    private BackupCommentService backupCommentService;

    @Scheduled(cron = SCHEDULE_CRON)
    public void backupHistoryCommentData(){//将历史数据进行备份到新表，并删除原来的
        logger.info("定时备份整理评论数据:"+SCHEDULE_CRON);
        backupCommentService.backup();
    }

}
