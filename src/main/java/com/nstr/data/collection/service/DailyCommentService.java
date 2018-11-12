package com.nstr.data.collection.service;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.DailyComment;

import java.util.List;

public interface DailyCommentService {

    PageInfo<DailyComment> findAll(List<String> dates, Integer number, Integer size, String type, String sort);
}
