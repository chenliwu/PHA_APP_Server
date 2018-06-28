package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.entity.UserFeedbackEntity;
import com.clw.phaapp.service.IUserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户反馈controller
 *
 * @author chenliwu
 * @create 2018-03-06 23:27
 **/
@Controller
@RequestMapping("/userFeedback")
public class UserFeedbackController {

    @Autowired
    private IUserFeedbackService mIUserFeedbackService;

    /**
     * 插入记录
     *
     * @param userFeedbackEntity
     * @return
     */
    @RequestMapping(value = "/insertRecord")
    @ResponseBody
    public ResultEntity insertRecord(HttpServletRequest request,UserFeedbackEntity userFeedbackEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userFeedbackEntity == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        String ip=request.getRemoteAddr();
        Long opdate= Long.parseLong(TimeUtils.getCurrentTime_5());
        userFeedbackEntity.setIp(ip);
        userFeedbackEntity.setOpdate(opdate);
        return mIUserFeedbackService.insertRecord(userFeedbackEntity);
    }


}
