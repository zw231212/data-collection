package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.Daily;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/spring.xml"})
public class RepositoryTest {

    @Resource
    private ResourceCommentMapper resourceCommentMapper;
    @Resource
    private StatisticMapper statisticMapper;

    @Test
    public void test(){
        List<Daily> dailies = statisticMapper.commonStatic();
        System.out.println(dailies);
    }

}
