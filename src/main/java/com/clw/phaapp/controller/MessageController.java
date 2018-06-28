package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.MessageEntity;
import com.clw.phaapp.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author clw
 * @create 2018-01-28 16:09
 **/
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService mIMessageService;


    /**
     * 分页查询消息记录
     *
     * @param messageEntity
     * @return
     */
    @RequestMapping(value = "/selectRecordsListByPage")
    @ResponseBody
    public ResultEntity selectRecordsListByPage(MessageEntity messageEntity) {
        return mIMessageService.selectRecordsListByPage(messageEntity);
    }



    /**
     * 修改消息状态，将消息修改成已读
     *
     * @param messageEntity
     * @return
     */
    @RequestMapping(value = "/updateRecord")
    @ResponseBody
    public ResultEntity updateRecord(MessageEntity messageEntity) {
        return mIMessageService.updateRecord(messageEntity);
    }



    /**
     * 将消息列表标为已读
     *
     * @param messageEntity
     * @return
     */
    @RequestMapping(value = "/updateMessageStatusByParam")
    @ResponseBody
    public ResultEntity updateMessageStatusByParam(MessageEntity messageEntity) {
        return mIMessageService.updateMessageStatusByParam(messageEntity);
    }



    /**
     * 根据参数获取消息记录数
     *  只查询未阅读的记录数
     *
     * @param messageEntity
     * @return
     */
    @RequestMapping(value = "/selectMessageTotalByParam")
    @ResponseBody
    public ResultEntity selectMessageTotalByParam(MessageEntity messageEntity) {
        return mIMessageService.selectMessageTotalByParam(messageEntity);
    }

}


