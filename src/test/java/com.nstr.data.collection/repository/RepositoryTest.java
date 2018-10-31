package com.nstr.data.collection.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/spring.xml"})
public class RepositoryTest {

    @Resource
    private ResourceCommentMapper resourceCommentMapper;

    @Test
    public void test(){
    }

}
