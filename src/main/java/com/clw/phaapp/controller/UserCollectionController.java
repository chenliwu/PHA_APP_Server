package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.UserCollectionEntity;
import com.clw.phaapp.service.IUserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户收藏Controller
 * @author chenliwu
 * @create 2018-04-06 12:43
 **/
@Controller
@RequestMapping("/userCollection")
public class UserCollectionController {

    @Autowired
    private IUserCollectionService mIUserCollectionService;

    /**
     * 分页查询，健康问答收藏记录
     * @param userCollectionEntity
     * @return
     */
    @RequestMapping(value = "/selectAskCollectionListByPage")
    @ResponseBody
    public ResultEntity selectAskCollectionListByPage(UserCollectionEntity userCollectionEntity){
        return mIUserCollectionService.selectAskCollectionListByPage(userCollectionEntity);
    }




    /**
     * 分页查询，健康资讯收藏记录
     * @param userCollectionEntity
     * @return
     */
    @RequestMapping(value = "/selectHealthInfoCollectionListByPage")
    @ResponseBody
    public ResultEntity selectHealthInfoCollectionListByPage(UserCollectionEntity userCollectionEntity){
        return mIUserCollectionService.selectHealthInfoCollectionListByPage(userCollectionEntity);
    }




    /**
     * 添加收藏记录
     * @param userCollectionEntity
     * @return
     */
    @RequestMapping(value = "/insertRecord")
    @ResponseBody
    public ResultEntity insertRecord(UserCollectionEntity userCollectionEntity){
        return mIUserCollectionService.insertRecord(userCollectionEntity);
    }

    /**
     * 分页查询，收藏记录
     * @param userCollectionEntity
     * @return
     */
    @RequestMapping(value = "/selectRecordsByPage")
    @ResponseBody
    public ResultEntity selectRecordsByPage(UserCollectionEntity userCollectionEntity){
        return mIUserCollectionService.selectRecordsByPage(userCollectionEntity);
    }

    /**
     * 删除单条收藏记录
     * @param userCollectionEntity
     * @return
     */
    @RequestMapping(value = "/deleteOneRecord")
    @ResponseBody
    public ResultEntity deleteOneRecord(UserCollectionEntity userCollectionEntity){
        return mIUserCollectionService.deleteOneRecord(userCollectionEntity);
    }

}
