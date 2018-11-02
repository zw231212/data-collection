package com.nstr.data.collection.api;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.response.APIResponse;
import com.nstr.data.collection.model.response.Message;
import com.nstr.data.collection.service.DailyColumnService;
import com.nstr.data.collection.util.DateUtil;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comments/daily-columns")
public class DailyColumnAPI {

  @Resource
  private DailyColumnService dailyColumnService;

  @RequestMapping("/list")
  public APIResponse findPage(
         @RequestParam(value = "account") String account,//账户id
         @RequestParam(value = "begin") String begin,//日期开始时间
         @RequestParam(value = "offset",required = false,defaultValue = "1") Integer offset,//日期偏移量
         @RequestParam(value = "type",required = false,defaultValue = "day") String type,//日期类型
         @RequestParam(value = "columns",required = false,defaultValue = "") String columnsStr,//要查询的列
         @RequestParam(value = "sort",required = false,defaultValue = "value DESC") String sort,//排序信息
         @RequestParam(value = "number",required = false,defaultValue = "0") Integer number,
         @RequestParam(value = "size",required = false,defaultValue = "10") Integer size){

    if(StringUtil.isNullOrBlank(account)){
      return APIResponse.fail(Message.PARAMS_LOSE);
    }
    if(StringUtil.isNullOrBlank(begin)){
      begin = DateUtil.getNow();
    }
    List<String> dates = DateUtil.getDates(begin, offset, type);
    List<String> columns = StringUtil.str2List(columnsStr,"-");

    PageInfo<DailyColumn> page = dailyColumnService.findAll(dates,number,size,type,sort,columns);

    return APIResponse.ok(page);
  }


}
