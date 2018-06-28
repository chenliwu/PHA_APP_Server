package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.service.IAskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 健康问答Controller
 *
 * @author chenliwu
 * @create 2018-03-08 22:33
 **/
@Controller
@RequestMapping("/ask")
public class AskController {

    @Autowired
    private IAskService mIAskService;

    /**
     * 设置问答访问次数加1
     *
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/setAskVisitCount")
    @ResponseBody
    public ResultEntity setAskVisitCount(AskEntity askEntity) {
        return mIAskService.setAskVisitCount(askEntity);
    }

    /**
     * 发起健康问答
     *
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/publishAsk")
    @ResponseBody
    public ResultEntity publishAsk(AskEntity askEntity) {
        return mIAskService.publishAsk(askEntity);
    }

    /**
     * 删除健康问答
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/deleteAsk")
    @ResponseBody
    public ResultEntity deleteAsk(AskEntity askEntity) {
        return mIAskService.deleteAsk(askEntity);
    }

    /**
     * 修改健康问答
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/reviseAsk")
    @ResponseBody
    public ResultEntity reviseAsk(AskEntity askEntity) {
        return mIAskService.reviseAsk(askEntity);
    }

    /**
     * 获取健康问答列表，分页
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/selectAskRecordListByPage")
    @ResponseBody
    public ResultEntity selectAskRecordListByPage(AskEntity askEntity) {
        return mIAskService.selectAskRecordListByPage(askEntity);
    }

    /**
     * 获取单条健康问答明细
     * @param askEntity
     * @return
     */
    @RequestMapping(value = "/selectOneAskRecord")
    @ResponseBody
    public ResultEntity selectOneAskRecord(AskEntity askEntity) {
        return mIAskService.selectAskRecordListByPage(askEntity);
    }

}
