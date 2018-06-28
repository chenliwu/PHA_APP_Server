package com.clw.phaapp.dao;

import com.clw.phaapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {




    /**
     *
     * @mbg.generated 2018-02-24
     */
    int deleteByPrimaryKey(Long recno);

    /**
     *
     * @mbg.generated 2018-02-24
     */
    int insert(UserEntity record);

    /**
     *
     * @mbg.generated 2018-02-24
     */
    int insertSelective(UserEntity record);

    /**
     *
     * @mbg.generated 2018-02-24
     */
    UserEntity selectByPrimaryKey(Long recno);

    /**
     *
     * @param param
     * @return
     */
    UserEntity selectOneByParam(UserEntity param);


    /**
     *
     * @mbg.generated 2018-02-24
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     *
     * @mbg.generated 2018-02-24
     */
    int updateByPrimaryKey(UserEntity record);

    /**
     * 找回密码
     * @mbg.generated 2018-02-24
     */
    int updatePwd(UserEntity record);
}