package com.clw.phaapp.service;


import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.UserEntity;

/**
 * @author clw
 * @create 2018-01-28 16:12
 **/
public interface IUserService {

    /**
     * 获取用户状态，返回status：0正常，1锁定
     * @param userEntity
     * @return
     */
    ResultEntity getUserStatus(UserEntity userEntity);

    /**
     * 用户注册
     * @param userEntity
     * @return
     */
    ResultEntity register(UserEntity userEntity);


    /**
     * 用户登录
     * @param userEntity
     * @return
     */
    ResultEntity login(UserEntity userEntity);


    /**
     * 获取用户信息
     * @param userEntity
     * @return
     */
    ResultEntity getUserInfo(UserEntity userEntity);

    /**
     * 修改信息
     * @param userEntity
     * @return
     */
    ResultEntity update(UserEntity userEntity);

    /**
     * 找回密码
     * @param userEntity
     * @return
     */
    ResultEntity findPwd(UserEntity userEntity);

    /**
     * 修改密码
     * @param userEntity
     * @return
     */
    ResultEntity revisePwd(UserEntity userEntity);


}
