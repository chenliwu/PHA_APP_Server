package com.clw.phaapp.dao;

import com.clw.phaapp.entity.AskAnswerEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskAnswerDao {


    /**
     * 获取问题的总回答个数
     * @param askrecno
     * @return
     */
    int selectAllAskAnswerCount(@Param("askrecno") Long askrecno);


    /**
     * 获取问题的回答个数（被采纳的）
     * @param askrecno
     * @return
     */
    int selectAcceptAskAnswerCount(@Param("askrecno") Long askrecno);



    /**
     * 查询回答记录数
     * @param askAnswerEntity
     * @return
     */
    int selectAllAskAnswerTotalByAskRecno(AskAnswerEntity askAnswerEntity);

    /**
     * 查询回答
     * @param askAnswerEntity
     * @return
     */
    List<AskAnswerEntity> selectAllAskAnswerByAskRecno(AskAnswerEntity askAnswerEntity);


    /**
     * 查询回答记录数，分页
     * @param askAnswerEntity
     * @return
     */
    int selectAskAnswerTotalByPage(AskAnswerEntity askAnswerEntity);

    /**
     * 查询回答列表，分页
     * @param askAnswerEntity
     * @return
     */
    List<AskAnswerEntity> selectAskAnswerByPage(AskAnswerEntity askAnswerEntity);


    /**
     * 删除指定记录
     * @param askAnswerEntity
     * @return
     */
    int deleteAnswerRecordsByParam(AskAnswerEntity askAnswerEntity);








    /**
     *
     * @mbg.generated 2018-03-23
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int insert(AskAnswerEntity record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int insertSelective(AskAnswerEntity record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    AskAnswerEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int updateByPrimaryKeySelective(AskAnswerEntity record);

    /**
     *
     * @mbg.generated 2018-03-23
     */
    int updateByPrimaryKey(AskAnswerEntity record);
}