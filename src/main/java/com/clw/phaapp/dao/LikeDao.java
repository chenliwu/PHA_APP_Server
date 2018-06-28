package com.clw.phaapp.dao;

import com.clw.phaapp.entity.LikeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeDao {

    /**
     * 根据参数删除记录
     * @param likeEntity
     * @return
     */
    int deleteRecordsByParam(LikeEntity likeEntity);



    /**
     * 获取被点赞次数
     * @param likeEntity
     * @return
     */
    int selectLikeCount(LikeEntity likeEntity);

    /**
     * 根据参数获取记录
     * @param likeEntity
     * @return
     */
    List<LikeEntity> selectRecordByParam(LikeEntity likeEntity);


    /**
     *
     * @mbg.generated 2018-03-27
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int insert(LikeEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int insertSelective(LikeEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    LikeEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int updateByPrimaryKeySelective(LikeEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int updateByPrimaryKey(LikeEntity record);
}