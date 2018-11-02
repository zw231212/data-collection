package com.nstr.data.collection.service.impl;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.HistoryComment;
import com.nstr.data.collection.repository.HistoryCommentMapper;
import com.nstr.data.collection.service.HistoryCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HistoryCommentServiceImpl implements HistoryCommentService {

    @Resource
    private HistoryCommentMapper historyCommentMapper;

    @Override
    public PageInfo<HistoryComment> findAll(String account, String resourceid, String userid, Integer year, Integer month, Integer day, String sort, Integer number, Integer size) {
        return null;
    }
}
