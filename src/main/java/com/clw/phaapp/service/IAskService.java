package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.entity.UserCollectionEntity;

/**
 * 健康问答
 */
public interface IAskService {


    /**
     * 设置问答访问次数加1
     * @param askEntity
     * @return
     */
    ResultEntity setAskVisitCount(AskEntity askEntity);


    /**
     * 发起健康问答
     * @param askEntity
     * @return
     */
    ResultEntity publishAsk(AskEntity askEntity);

    /**
     * 删除健康问答
     * @param askEntity
     * @return
     */
    ResultEntity deleteAsk(AskEntity askEntity);

    /**
     * 修改健康问答
     * @param askEntity
     * @return
     */
    ResultEntity reviseAsk(AskEntity askEntity);

    /**
     * 获取健康问答列表，分页
     * @param askEntity
     * @return
     */
    ResultEntity selectAskRecordListByPage(AskEntity askEntity);

    /**
     * 获取单条健康问答明细
     * @param askEntity
     * @return
     */
    ResultEntity selectOneAskRecord(AskEntity askEntity);

}
