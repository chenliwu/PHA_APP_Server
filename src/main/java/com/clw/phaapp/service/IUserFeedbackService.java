package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.UserFeedbackEntity;

/**
 * 用户反馈接口
 */
public interface IUserFeedbackService {

    /**
     * 插入记录
     * @param userFeedbackEntity
     * @return
     */
    ResultEntity insertRecord(UserFeedbackEntity userFeedbackEntity);


}
