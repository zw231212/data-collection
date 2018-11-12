package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.model.TagField;
import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.model.pojo.DailyComment;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.repository.*;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.service.StatisticService;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.JSONUtil;
import com.nstr.data.collection.util.KeywordsUtil;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;
    @Resource
    private DailyColumnMapper dailyColumnMapper;
    @Resource
    private DailyCommentMapper dailyCommentMapper;
    @Resource
    private DailyMapper dailyMapper;
    @Resource
    private ResourceCommentService resourceCommentService;

    @Override
    public void dailyStatistic() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        List<String> scs = AppConstant.statisticColumns;
        //获取开始与结束时间
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

    @Override
    public void dailyCommentStatistic() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        Long[] bes = DateUtil.getLongTypeBeginAndEnd("day",year,month,day);

        List<ResourceComment> comments = resourceCommentService.findByCreateTime(bes[0], bes[1]);
        String dayStr = DateUtil.getFormerDate(year + "" + month + "" + day, "yyyyMMdd");

        //删除旧数据
        statisticMapper.deleteSameDayData(AppConstant.DAILY_COMMENT_TABLE,dayStr);

        if(comments == null || comments.size() ==0){
            return;
        }
        //记录分词信息
        Map<String,Map<String,TagField> > keywordsMap = new HashMap<>();
        //记录个数信息
        Map<String,Integer> values = new HashMap<>();

        for (ResourceComment comment : comments) {
            String account = comment.getAccount();
            //统计个数信息
            boolean flag = values.containsKey(account);
            if (flag){
                Integer ovalue = values.get(account);
                values.put(account, ovalue+1);
            }else {
                values.put(account, 1);
            }

            //拿出当前账户的keyword存储信息
            Map<String, TagField> keywordMap = keywordsMap.get(account);
            if(keywordMap == null){
                keywordMap = new HashMap<>();
            }

            //关键词抽取
            String content = comment.getContent();
            if(StringUtil.isNullOrBlank(content)){
                continue;
            }
            List<TagField> keywords = KeywordsUtil.keywords(content);
            if(keywords == null || keywords.size() == 0){
                continue;
            }

            //关键词整合到一起去
            for (TagField tag : keywords) {
                String name = tag.getName();
                boolean contains = keywordMap.containsKey(name);
                if (contains){
                    TagField tagInmap = keywordMap.get(name);
                    tag.setValue(tagInmap.getValue()+tag.getValue());
                    keywordMap.put(name, tag);
                }else {
                    keywordMap.put(tag.getName(),tag);
                }
            }
            keywordsMap.put(account, keywordMap);
        }
        if(keywordsMap.size() == 0){
            return;
        }
        //将我们整合的信息整理成我们需要存储的格式
        List<DailyComment> commentsList = new ArrayList<>();
        //自定义Comparator对象，自定义排序
        for (String account : keywordsMap.keySet()) {
            DailyComment comment = new DailyComment();
            comment.setAccount(account);
            comment.setCreateTime(System.currentTimeMillis());
            comment.setDay(dayStr);
            Integer val = values.get(account);
            comment.setValue(val);
            Map<String, TagField> tagFieldMap = keywordsMap.get(account);

            Collection<TagField> tagFields = tagFieldMap.values();
            List<TagField> fields = new ArrayList<>(tagFields);
            fields.sort((Comparator<TagField>) (o1, o2) -> o2.getValue() - o1.getValue());
            if(fields.size() > 20){
                fields = fields.subList(0, AppConstant.DEFAULT_TAG_SIZE);
            }
            String tags = JSONUtil.obj2String(fields);
            comment.setTags(tags);

            commentsList.add(comment);
        }
        dailyCommentMapper.insertBatch(commentsList);
    }
}
