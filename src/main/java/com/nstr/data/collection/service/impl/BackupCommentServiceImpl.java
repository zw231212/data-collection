package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.repository.CommonMapper;
import com.nstr.data.collection.repository.ResourceCommentMapper;
import com.nstr.data.collection.service.BackupCommentService;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BackupCommentServiceImpl implements BackupCommentService {

    private static final Logger logger = LoggerFactory.getLogger(BackupCommentServiceImpl.class);

    @Resource
    private CommonMapper commonMapper;
    @Resource
    private ResourceCommentService resourceCommentService;


    @Override
    public void backup() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        if("month".equals(AppConstant.BACKUP_TYPE)){
            calendar.add(Calendar.MONTH, -1);
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) +1;
        }else if("week".equals(AppConstant.BACKUP_TYPE)){
            calendar.add(Calendar.DATE, -7);
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) +1;
            day = calendar.get(Calendar.DATE);
        }

        //一般都是这个月去生成上个月的备份表，或者今天生成昨天的备份表的名称
        String table = TableUtil.generateTableName(AppConstant.COMMENT_TABLE,AppConstant.BACKUP_TYPE);
        List<String> exists = commonMapper.exists(table);
        if(exists == null || exists.size() == 0){
            commonMapper.createBackUpTable(table);
            Long[] bes = DateUtil.getLongTypeBeginAndEnd(AppConstant.BACKUP_TYPE,year,month,day);
            commonMapper.transferData(bes[0], bes[1], new Date(), table);
//            resourceCommentService.delete(bes[0], bes[1]);
        }else{
            logger.warn("数据库已经存在备份数据表："+table);
        }

    }
}
