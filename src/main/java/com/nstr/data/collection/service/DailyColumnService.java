package com.nstr.data.collection.service;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyColumn;

import java.util.List;

public interface DailyColumnService {

    PageInfo<DailyColumn> findAll(List<String> dates, Integer number, Integer size,
                                  String type, String sort, List<String> columns);
}
