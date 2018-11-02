package com.nstr.data.collection.service;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.HistoryComment;

public interface HistoryCommentService {
    PageInfo<HistoryComment> findAll(String account, String resourceid, String userid,
                                     Integer year, Integer month, Integer day,
                                     String sort, Integer number, Integer size);
}
