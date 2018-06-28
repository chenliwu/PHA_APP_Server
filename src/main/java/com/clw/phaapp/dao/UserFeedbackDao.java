package com.clw.phaapp.dao;

import com.clw.phaapp.entity.UserFeedbackEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeedbackDao {
    /**
     *
     * @mbg.generated 2018-03-06
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-06
     */
    int insert(UserFeedbackEntity record);

    /**
     *
     * @mbg.generated 2018-03-06
     */
    int insertSelective(UserFeedbackEntity record);

    /**
     *
     * @mbg.generated 2018-03-06
     */
    UserFeedbackEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-03-06
     */
    int updateByPrimaryKeySelective(UserFeedbackEntity record);

    /**
     *
     * @mbg.generated 2018-03-06
     */
    int updateByPrimaryKey(UserFeedbackEntity record);
}