package com.nstr.data.collection;


import com.nstr.data.collection.model.pojo.ResourceComment;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.nstr.data.collection.repository.ResourceCommentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/spring.xml"})
public class SpringBaseTest {

  @Resource
  private DataSource dataSource;
  @Resource
  private ResourceCommentMapper resourceCommentRepository;

  @Test
  public void testDS(){
    ResourceComment rc = new ResourceComment();
    rc.setAccount("123123");
    rc.setResourceid("w12312312312");
    rc.setContact("010-82338084");
    rc.setContent("12312312312312222222222222222222222222222222222222");
    System.out.println(resourceCommentRepository);
//    System.out.println(resourceCommentRepository.save(rc));
    System.out.println(dataSource);
    Assert.assertNotNull(dataSource);
  }

}
