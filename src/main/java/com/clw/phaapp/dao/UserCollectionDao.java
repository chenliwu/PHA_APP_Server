package com.clw.phaapp.dao;

import com.clw.phaapp.entity.UserCollectionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCollectionDao {

    /**
     * 分页查询收藏记录数
     * @param userCollectionEntity
     * @return
     */
    int selectRecordsTotalByPage(UserCollectionEntity userCollectionEntity);

    /**
     * 分页查询收藏记录
     * @param userCollectionEntity
     * @return
     */
    List<UserCollectionEntity> selectRecordsByPage(UserCollectionEntity userCollectionEntity);


    /**
     *
     * @mbg.generated 2018-04-06
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-06
     */
    int insert(UserCollectionEntity record);

    /**
     *
     * @mbg.generated 2018-04-06
     */
    int insertSelective(UserCollectionEntity record);

    /**
     *
     * @mbg.generated 2018-04-06
     */
    UserCollectionEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-06
     */
    int updateByPrimaryKeySelective(UserCollectionEntity record);

    /**
     *
     * @mbg.generated 2018-04-06
     */
    int updateByPrimaryKey(UserCollectionEntity record);
}