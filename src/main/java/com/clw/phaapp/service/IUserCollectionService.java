package com.clw.phaapp.service;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.UserCollectionEntity;

/**
 * 用户收藏
 */
public interface IUserCollectionService {


    /**
     * 分页查询，健康问答收藏记录
     * @param userCollectionEntity
     * @return
     */
    ResultEntity selectAskCollectionListByPage(UserCollectionEntity userCollectionEntity);


    /**
     * 分页查询，健康资讯收藏记录
     * @param userCollectionEntity
     * @return
     */
    ResultEntity selectHealthInfoCollectionListByPage(UserCollectionEntity userCollectionEntity);



    /**
     * 添加收藏记录
     * @param userCollectionEntity
     * @return
     */
    ResultEntity insertRecord(UserCollectionEntity userCollectionEntity);

    /**
     * 分页查询，收藏记录
     * @param userCollectionEntity
     * @return
     */
    ResultEntity selectRecordsByPage(UserCollectionEntity userCollectionEntity);



    /**
     * 删除单条收藏记录
     * @param userCollectionEntity
     * @return
     */
    ResultEntity deleteOneRecord(UserCollectionEntity userCollectionEntity);



}
