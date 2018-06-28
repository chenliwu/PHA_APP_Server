package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.ReportEntity;
import com.clw.phaapp.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 举报处理Controller
 * @author chenliwu
 * @create 2018-04-08 0:45
 **/
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService mIReportService;

    /**
     * 添加举报记录
     * @param reportEntity
     * @return
     */
    @RequestMapping(value = "/insertRecord")
    @ResponseBody
    public ResultEntity insertRecord(ReportEntity reportEntity){
        return mIReportService.insertRecord(reportEntity);
    }


    /**
     * 分页查询，举报记录
     * @param reportEntity
     * @return
     */
    @RequestMapping(value = "/selectRecordsByPage")
    @ResponseBody
    public ResultEntity selectRecordsByPage(ReportEntity reportEntity){
        return mIReportService.selectRecordsByPage(reportEntity);
    }


    /**
     * 修改举报记录
     * @param reportEntity
     * @return
     */
    @RequestMapping(value = "/updateRecord")
    @ResponseBody
    public ResultEntity updateRecord(ReportEntity reportEntity){
        return mIReportService.updateRecord(reportEntity);
    }


}
