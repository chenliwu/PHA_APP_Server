package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.UserEntity;
import com.clw.phaapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author clw
 * @create 2018-01-28 16:09
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService mIUserService;


    /**
     * 获取用户状态，返回status：0正常，1锁定
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/getUserStatus")
    @ResponseBody
    public ResultEntity getUserStatus(UserEntity userEntity) {
        return mIUserService.getUserStatus(userEntity);
    }


    /**
     * 注册账号
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public ResultEntity register(UserEntity userEntity) {
        return mIUserService.register(userEntity);
    }


    /**
     * 用户登录
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultEntity login(UserEntity userEntity) {
        return mIUserService.login(userEntity);
    }



    /**
     * 修改密码
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/revisePwd")
    @ResponseBody
    public ResultEntity revisePwd(UserEntity userEntity) {
        return mIUserService.revisePwd(userEntity);
    }

    /**
     * 找回密码
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/findPwd")
    @ResponseBody
    public ResultEntity findPwd(UserEntity userEntity) {
        return mIUserService.findPwd(userEntity);
    }

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public ResultEntity getUserInfo(UserEntity userEntity) {
        return mIUserService.getUserInfo(userEntity);
    }

    /**
     * 修改信息
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultEntity update(UserEntity userEntity) {
        return mIUserService.update(userEntity);
    }


}


