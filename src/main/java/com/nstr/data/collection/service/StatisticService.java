package com.nstr.data.collection.service;

public interface StatisticService {

    /**
     * 每日基本数据统计，定时调度
     */
    void dailyStatistic();

    /**
     * 每日评论数据统计，定时调度
     */
    void dailyCommentStatistic();
}
