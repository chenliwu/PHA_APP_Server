package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.AskAnswerEntity;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.entity.LikeEntity;

public interface IAskAnswerService {


    /**
     * 设置访问次数加1
     * @param askAnswerEntity
     * @return
     */
    ResultEntity setAskAnswerVisitCount(AskAnswerEntity askAnswerEntity);


    /**
     *
     * @param askAnswerEntity
     * @return
     */
    ResultEntity insertRecord(AskAnswerEntity askAnswerEntity);

    /**
     * 获取回答列表
     * @param askAnswerEntity
     * @return
     */
    ResultEntity getAskAnswerList(AskAnswerEntity askAnswerEntity);


    /**
     * 查询回答列表，分页
     * @param askAnswerEntity
     * @return
     */
    ResultEntity selectAskAnswerByPage(AskAnswerEntity askAnswerEntity);


    /**
     * 采纳回答
     * @param askAnswerEntity
     * @return
     */
    ResultEntity acceptAskAnswer(AskAnswerEntity askAnswerEntity);

    /**
     * 删除回答
     * @param askAnswerEntity
     * @return
     */
    ResultEntity deleteAskAnswer(AskAnswerEntity askAnswerEntity);


    /**
     * 点赞
     * @param likeEntity
     * @return
     */
    ResultEntity like(LikeEntity likeEntity);


}
