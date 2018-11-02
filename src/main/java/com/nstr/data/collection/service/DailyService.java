package com.nstr.data.collection.service;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.Daily;

import java.util.List;

public interface DailyService {

    PageInfo<Daily> findAll(List<String> dates, Integer number, Integer size, String type, String sort);
}
