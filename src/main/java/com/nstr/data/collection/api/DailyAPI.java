package com.nstr.data.collection.api;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.response.APIResponse;
import com.nstr.data.collection.model.response.Message;
import com.nstr.data.collection.service.DailyService;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comments/daily")
public class DailyAPI {

  @Resource
  private DailyService dailyService;


  @RequestMapping("/list")
  public APIResponse findPage( //这里的寻找应该是要通用的，先不写那么多
      @RequestParam(value = "account") String account,
      @RequestParam(value = "begin") String begin,
      @RequestParam(value = "offset",required = false,defaultValue = "0") Integer offset,
      @RequestParam(value = "type",required = false,defaultValue = "day") String type,
      @RequestParam(value = "sort",required = false,defaultValue = "value DESC") String sort,
      @RequestParam(value = "number",required = false,defaultValue = "0") Integer number,
      @RequestParam(value = "size",required = false,defaultValue = "10") Integer size){

    if(StringUtil.isNullOrBlank(account)){
      return APIResponse.fail(Message.PARAMS_LOSE);
    }
    if(StringUtil.isNullOrBlank(begin)){
      begin = DateUtil.getNow();
    }
    //获取全部的日期信息
    List<String> dates = DateUtil.getDates(begin, offset, type);

    PageInfo<Daily> page = dailyService.findAll(dates, number, size, type, sort);

    return APIResponse.ok(page);
  }

}
