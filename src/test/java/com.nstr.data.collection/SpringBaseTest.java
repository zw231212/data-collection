package com.nstr.data.collection;


import com.nstr.data.collection.repository.ResourceCommentRepository;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:conf/spring/spring.xml")
public class SpringBaseTest {

  @Resource
  private DataSource dataSource;
  @Resource
  private ResourceCommentRepository resourceCommentRepository;

  @Test
  public void testDS(){
    System.out.println(resourceCommentRepository);
    System.out.println(dataSource);
    Assert.assertNotNull(dataSource);
  }

}
