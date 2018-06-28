package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.entity.LogEntity;
import com.clw.phaapp.entity.UserFeedbackEntity;
import com.clw.phaapp.service.ILogService;
import com.clw.phaapp.service.IUserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志controller
 *
 * @author chenliwu
 * @create 2018-03-06 23:27
 **/
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private ILogService mILogService;

    /**
     * 插入记录
     *
     * @param logEntity
     * @return
     */
    @RequestMapping(value = "/insertLogRecord")
    @ResponseBody
    public ResultEntity insertLogRecord(LogEntity logEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(logEntity == null || logEntity.getType()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        logEntity.setOpdate(opdate);
        return mILogService.insertLogRecord(logEntity);
    }

    /**
     * 查询访问日志，获取浏览历史
     *
     * @param logEntity
     * @return
     */
    @RequestMapping(value = "/selectVisitHistoryRecordsByPage")
    @ResponseBody
    public ResultEntity selectVisitHistoryRecordsByPage(LogEntity logEntity) {
        return mILogService.selectVisitHistoryRecordsByPage(logEntity);
    }


}
