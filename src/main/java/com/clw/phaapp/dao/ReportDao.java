package com.clw.phaapp.dao;

import com.clw.phaapp.entity.ReportEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {

    /**
     * 分页查询举报记录总记录数
     * @param reportEntity
     * @return
     */
    int selectRecordsTotalByPage(ReportEntity reportEntity);

    /**
     * 分页查询举报记录
     * @param reportEntity
     * @return
     */
    List<ReportEntity> selectRecordsByPage(ReportEntity reportEntity);


    /**
     *
     * @mbg.generated 2018-04-08
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-08
     */
    int insert(ReportEntity record);

    /**
     *
     * @mbg.generated 2018-04-08
     */
    int insertSelective(ReportEntity record);

    /**
     *
     * @mbg.generated 2018-04-08
     */
    ReportEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-08
     */
    int updateByPrimaryKeySelective(ReportEntity record);

    /**
     *
     * @mbg.generated 2018-04-08
     */
    int updateByPrimaryKey(ReportEntity record);
}