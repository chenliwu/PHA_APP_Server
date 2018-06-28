package com.clw.phaapp.dao;

import com.clw.phaapp.entity.AskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskDao {

    /**
     * 设置问答访问次数加1
     * @param askEntity
     * @return
     */
    int setAskVisitCount(AskEntity askEntity);


    /**
     *
     * @mbg.generated 2018-03-08
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-08
     */
    int insert(AskEntity record);

    /**
     *
     * @mbg.generated 2018-03-08
     */
    int insertSelective(AskEntity record);

    /**
     *
     * @mbg.generated 2018-03-08
     */
    AskEntity selectByPrimaryKey(Long recno);

    /**
     * 分页查询健康问答列表，获取记录数
     * @param askEntity
     * @return
     */
    int selectAskRecordListTotalByPage(AskEntity askEntity);

    /**
     * 分页查询健康问答列表
     * @param askEntity
     * @return
     */
    List<AskEntity> selectAskRecordListByPage(AskEntity askEntity);

    /**
     * 获取单条健康问答明细
     * @param askEntity
     * @return
     */
    AskEntity selectOneAskRecord(AskEntity askEntity);

    /**
     *
     * @mbg.generated 2018-03-08
     */
    int updateByPrimaryKeySelective(AskEntity record);

    /**
     *
     * @mbg.generated 2018-03-08
     */
    int updateByPrimaryKey(AskEntity record);
}