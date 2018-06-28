package com.clw.phaapp.dao;

import com.clw.phaapp.entity.MessageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    /**
     * 根据参数修改消息状态，将消息变成已读状态
     * @param messageEntity
     * @return
     */
    int updateRecordsStatusByParam(MessageEntity messageEntity);


    /**
     * 获取记录数
     * @param messageEntity
     * @return
     */
    int selectRecordsTotalByPage(MessageEntity messageEntity);

    /**
     * 分页查询消息记录
     * @param messageEntity
     * @return
     */
    List<MessageEntity> selectRecordsListByPage(MessageEntity messageEntity);



    /**
     *
     * @mbg.generated 2018-04-10
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-10
     */
    int insert(MessageEntity record);

    /**
     *
     * @mbg.generated 2018-04-10
     */
    int insertSelective(MessageEntity record);

    /**
     *
     * @mbg.generated 2018-04-10
     */
    MessageEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-04-10
     */
    int updateByPrimaryKeySelective(MessageEntity record);

    /**
     *
     * @mbg.generated 2018-04-10
     */
    int updateByPrimaryKey(MessageEntity record);
}