package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.LogEntity;

public interface ILogService {

    /**
     * 插入一条访问日志
     * @param logEntity
     * @return
     */
    ResultEntity insertLogRecord(LogEntity logEntity);

    /**
     * 查询访问日志，获取浏览历史
     * @param logEntity
     * @return
     */
    ResultEntity selectVisitHistoryRecordsByPage(LogEntity logEntity);

}
