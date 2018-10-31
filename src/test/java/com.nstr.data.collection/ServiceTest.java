package com.nstr.data.collection;


import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.ResourceComment;
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

  @Test
  public void testFindPage(){
    String id ="web-uuid123";
    String resourceid= null;
    String userid = null;
    PageInfo<ResourceComment> page = resourceCommentService.findPage(id, resourceid, userid, 0, 10);
    System.out.println(page.getList());
  }

}
