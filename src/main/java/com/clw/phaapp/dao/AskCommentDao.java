package com.clw.phaapp.dao;

import com.clw.phaapp.entity.AskCommentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AskCommentDao {

    /**
     * 根据参数删除记录
     * @param askCommentEntity
     * @return
     */
    int deleteRecordsByParam(AskCommentEntity askCommentEntity);


    /**
     *
     * @mbg.generated 2018-03-27
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int insert(AskCommentEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int insertSelective(AskCommentEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    AskCommentEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int updateByPrimaryKeySelective(AskCommentEntity record);

    /**
     *
     * @mbg.generated 2018-03-27
     */
    int updateByPrimaryKey(AskCommentEntity record);
}