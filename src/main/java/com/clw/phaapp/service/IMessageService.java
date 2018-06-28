package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.MessageEntity;

public interface IMessageService {

    /**
     * 分页查询消息记录
     * @param messageEntity
     * @return
     */
    ResultEntity selectRecordsListByPage(MessageEntity messageEntity);

    /**
     * 修改消息状态
     * @param messageEntity
     * @return
     */
    ResultEntity updateRecord(MessageEntity messageEntity);

    /**
     * 根据参数获取消息记录数
     * @param messageEntity
     * @return
     */
    ResultEntity selectMessageTotalByParam(MessageEntity messageEntity);



    /**
     * 将消息列表标为已读
     * @param messageEntity
     * @return
     */
    ResultEntity updateMessageStatusByParam(MessageEntity messageEntity);


}
