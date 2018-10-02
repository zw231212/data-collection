package com.nstr.data.collection;


import com.nstr.data.collection.service.ResourceCommentService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/spring.xml"})
public class ServiceTest {


  @Resource
  private ResourceCommentService resourceCommentService;

  @Test
  public void testService(){
    System.out.println(resourceCommentService);
  }

}
