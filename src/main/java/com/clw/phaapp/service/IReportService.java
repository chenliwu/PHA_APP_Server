package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.ReportEntity;

/**
 * 举报
 */
public interface IReportService {

    /**
     * 添加举报记录
     * @param reportEntity
     * @return
     */
    ResultEntity insertRecord(ReportEntity reportEntity);

    /**
     * 分页查询，举报记录
     * @param reportEntity
     * @return
     */
    ResultEntity selectRecordsByPage(ReportEntity reportEntity);

    /**
     * 修改举报记录
     * @param reportEntity
     * @return
     */
    ResultEntity updateRecord(ReportEntity reportEntity);

}
