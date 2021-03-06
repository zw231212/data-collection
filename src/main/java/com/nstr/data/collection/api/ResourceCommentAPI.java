package com.nstr.data.collection.api;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.response.APIResponse;
import com.nstr.data.collection.model.response.Message;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.StringUtil;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里只能获取到这个备份周期内的数据，以前的数据需要调用另外的接口
 */
@RestController
@RequestMapping("/comments/resources")
public class ResourceCommentAPI {

  @Resource
  private ResourceCommentService resourceCommentService;


  @RequestMapping("/list")
  public APIResponse findPage( //这里的寻找应该是要通用的，先不写那么多
      @RequestParam(value = "account") String account,
      @RequestParam(value = "resourceid",required = false) String resourceid,
      @RequestParam(value = "userid",required = false) String userid,
      @RequestParam(value = "number",required = false,defaultValue = "0") Integer number,
      @RequestParam(value = "size",required = false,defaultValue = "10") Integer size){

    if(StringUtil.isNullOrBlank(account)){
      return APIResponse.fail(Message.PARAMS_LOSE);
    }

    PageInfo<ResourceComment> page = resourceCommentService.findPage(account, resourceid, userid, number, size);

    return APIResponse.ok(page);
  }

  @RequestMapping("/detail/{id}/get")
  public APIResponse getDetail(
      @PathVariable(value = "id") Long id
      ){
    ResourceComment rc = resourceCommentService.findOne(id);
    return APIResponse.ok(rc);
  }


}
