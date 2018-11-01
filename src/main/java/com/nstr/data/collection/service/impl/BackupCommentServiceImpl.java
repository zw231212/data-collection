package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.repository.CommonMapper;
import com.nstr.data.collection.service.BackupCommentService;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BackupCommentServiceImpl implements BackupCommentService {

    private static final Logger logger = LoggerFactory.getLogger(BackupCommentServiceImpl.class);

    @Resource
    private CommonMapper commonMapper;


    @Override
    public void backup() {
        //获取上月信息或者上周信息（月备份和周备份）
        String dateStr = TableUtil.generateDateStr(AppConstant.BACKUP_TYPE);

        //一般都是这个月去生成上个月的备份表，或者今天生成昨天的备份表
        String table = TableUtil.generateTableName(AppConstant.COMMENT_TABLE,AppConstant.BACKUP_TYPE);
        List<String> exists = commonMapper.exists(table);
        if(exists == null || exists.size() == 0){
            commonMapper.createBackUpTable(table);
            Long[] bes = DateUtil.getLongTypeBeginAndEnd("month",1,2,0);
            commonMapper.transferData(bes[0], bes[1], new Date(), table);
        }else{
            logger.warn("数据库已经存在备份数据表："+table);
        }

    }
}
