package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.TableUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/spring.xml"})
public class RepositoryTest {

    @Resource
    private ResourceCommentMapper resourceCommentMapper;
    @Resource
    private StatisticMapper statisticMapper;

    @Resource
    private HistoryCommentMapper historyCommentMapper;
    @Resource
    private CommonMapper commonMapper;

    @Test
    public void test(){
        Long[] days = DateUtil.getLongTypeBeginAndEnd("day", 2018, 11, 1);
        List<Daily> dailies = statisticMapper.commonStatic(days[0],days[1]);
        System.out.println(dailies);
    }

    @Test
    public void testArea(){
        Long[] days = DateUtil.getLongTypeBeginAndEnd("day", 2018, 11, 1);
        List<DailyColumn> columns = statisticMapper.columnStatic("area",days[0], days[1]);
        for (DailyColumn dailyColumn : columns) {
            System.out.println(dailyColumn);
        }
    }

    @Test
    public void testCreateTable(){
        commonMapper.createBackUpTable(TableUtil.generateTableName("", "month"));
    }

    @Test
    public void testExists(){
        List<String> t1 = commonMapper.exists("nstr_resource_comment");
        List<String> t2= commonMapper.exists("nstr_resource_c");
        System.out.println(t1);
        System.out.println(t2);
    }
}
