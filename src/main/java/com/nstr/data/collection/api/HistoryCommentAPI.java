package com.nstr.data.collection.api;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.HistoryComment;
import com.nstr.data.collection.model.response.APIResponse;
import com.nstr.data.collection.model.response.Message;
import com.nstr.data.collection.service.HistoryCommentService;
import com.nstr.data.collection.util.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 历史评论数据model是和ResourceComment字段基本一样的，本来是继承的，但是因为model和mapper是generator生成的原因，所以分开了
 * HistoryComment只是增加了几个字段：generation_time,table_name,gid
 */
@RestController
@RequestMapping("/comments/history-comment")
public class HistoryCommentAPI {

    @Resource
    private HistoryCommentService historyCommentService;

    @RequestMapping("/list")
    public APIResponse findPage( //这里的寻找应该是要通用的，先不写那么多
         @RequestParam(value = "account") String account,
         @RequestParam(value = "resourceid") String resourceid,
         @RequestParam(value = "userid") String userid,
         @RequestParam(value = "year") Integer year,
         @RequestParam(value = "month") Integer month,
         @RequestParam(value = "day",required = false,defaultValue = "1") Integer day,
         @RequestParam(value = "sort",required = false,defaultValue = "score DESC") String sort,
         @RequestParam(value = "number",required = false,defaultValue = "0") Integer number,
         @RequestParam(value = "size",required = false,defaultValue = "10") Integer size){

        if(StringUtil.isNullOrBlank(account)){
            return APIResponse.fail(Message.PARAMS_LOSE);
        }

        PageInfo<HistoryComment> page = historyCommentService.findAll(account,resourceid, userid, year, month, day, sort, number,size);

        return APIResponse.ok(page);
    }


}
