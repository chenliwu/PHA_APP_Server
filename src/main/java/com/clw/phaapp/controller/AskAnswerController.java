package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.AskAnswerEntity;
import com.clw.phaapp.entity.LikeEntity;
import com.clw.phaapp.service.IAskAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 回答问题
 *
 * @author chenliwu
 * @create 2018-03-23 21:29
 **/
@Controller
@RequestMapping("/askAnswer")
public class AskAnswerController {

    @Autowired
    private IAskAnswerService mIAskAnswerService;

    /**
     * 回答问题
     *
     * @param askAnswerEntity
     * @return
     */
    @RequestMapping(value = "/publishAskAnswer")
    @ResponseBody
    public ResultEntity publishAskAnswer(AskAnswerEntity askAnswerEntity) {
        return mIAskAnswerService.insertRecord(askAnswerEntity);
    }


    /**
     * 获取问答列表
     *
     * @param askAnswerEntity
     * @return
     */
    @RequestMapping(value = "/getAskAnswerList")
    @ResponseBody
    public ResultEntity getAskAnswerList(AskAnswerEntity askAnswerEntity) {
        return mIAskAnswerService.getAskAnswerList(askAnswerEntity);
    }

    /**
     * 获取问答列表，分页
     *
     * @param askAnswerEntity
     * @return
     */
    @RequestMapping(value = "/selectAskAnswerByPage")
    @ResponseBody
    public ResultEntity selectAskAnswerByPage(AskAnswerEntity askAnswerEntity) {
        return mIAskAnswerService.selectAskAnswerByPage(askAnswerEntity);
    }

    /**
     * 采纳回答
     *
     * @param askAnswerEntity
     * @return
     */
    @RequestMapping(value = "/acceptAskAnswer")
    @ResponseBody
    public ResultEntity acceptAskAnswer(AskAnswerEntity askAnswerEntity) {
        return mIAskAnswerService.acceptAskAnswer(askAnswerEntity);
    }


    /**
     * 删除回答
     *
     * @param askAnswerEntity
     * @return
     */
    @RequestMapping(value = "/deleteAskAnswer")
    @ResponseBody
    public ResultEntity deleteAskAnswer(AskAnswerEntity askAnswerEntity) {
        return mIAskAnswerService.deleteAskAnswer(askAnswerEntity);
    }

    /**
     * 点赞回答
     *
     * @param likeEntity
     * @return
     */
    @RequestMapping(value = "/like")
    @ResponseBody
    public ResultEntity like(LikeEntity likeEntity) {
        return mIAskAnswerService.like(likeEntity);
    }



}
