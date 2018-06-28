package com.clw.phaapp.dao;

import com.clw.phaapp.entity.LogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {


    /**
     * 查询浏览历史总记录数
     * @param logEntity
     * @return
     */
    int selectVisitHistoryRecordsTotalByPage(LogEntity logEntity);

    /**
     * 查询浏览历史
     * @param logEntity
     * @return
     */
    List<LogEntity> selectVisitHistoryRecordsByPage(LogEntity logEntity);




    /**
     *
     * @mbg.generated 2018-03-20
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-20
     */
    int insert(LogEntity record);

    /**
     *
     * @mbg.generated 2018-03-20
     */
    int insertSelective(LogEntity record);

    /**
     *
     * @mbg.generated 2018-03-20
     */
    LogEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-20
     */
    int updateByPrimaryKeySelective(LogEntity record);

    /**
     *
     * @mbg.generated 2018-03-20
     */
    int updateByPrimaryKey(LogEntity record);
}