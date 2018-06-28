package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.dao.UserDao;
import com.clw.phaapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clw.phaapp.service.IUserService;

/**
 * @author clw
 * @create 2018-01-28 16:15
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao mUserDao;

    /**
     * 获取用户状态，返回status：0正常，1锁定
     *
     * @param userEntity
     * @return
     */
    @Override
    public ResultEntity getUserStatus(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null || userEntity.getRecno() == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        UserEntity entity=mUserDao.selectByPrimaryKey(userEntity.getRecno());
        if(entity != null){
            byte status=entity.getStatus();
            resultEntity.setState(200);
            resultEntity.setData(status);
        }else{
            resultEntity.setMessage("获取用户状态失败");
        }
        return resultEntity;
    }

    /**
     * 注册账号
     * @param userEntity
     * @return
     */
    @Override
    public ResultEntity register(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        //注册之前需要先查询账号是否被注册了
        UserEntity entity=new UserEntity();
        entity.setUsercode(userEntity.getUsercode());
        if(mUserDao.selectOneByParam(entity) == null){  //用户未注册
            Integer regdate=Integer.parseInt(TimeUtils.getCurrentTime_4());
            userEntity.setRegdate(regdate);
            if(mUserDao.insertSelective(userEntity) > 0){
                resultEntity.setState(200);
                resultEntity.setMessage("注册成功");
            }else{
                resultEntity.setMessage("注册失败");
            }
        }else{
            //用户已经注册
            resultEntity.setState(500);
            resultEntity.setMessage("账号已经存在，请重新输入账号");
        }
        return resultEntity;
    }

    @Override
    public ResultEntity login(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        UserEntity entity=mUserDao.selectOneByParam(userEntity);
        if(entity != null){
            if(entity.getStatus() == 0){
                resultEntity.setState(200);
                resultEntity.setData(entity);
                resultEntity.setMessage("登录成功");
            }else if(entity.getStatus() == 1){
                resultEntity.setMessage("该用户已被锁定，请联系管理员");
            }
        }else{
            resultEntity.setMessage("登录失败，账号或密码错误");
        }
        return resultEntity;
    }


    /**
     * 获取用户信息
     *
     * @param userEntity
     * @return
     */
    @Override
    public ResultEntity getUserInfo(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null || userEntity.getUsercode()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        UserEntity entity=mUserDao.selectOneByParam(userEntity);
        if(entity!=null){
            //用户存在则返回代码200
            resultEntity.setState(200);
            resultEntity.setData(entity);
        }
        return resultEntity;
    }

    @Override
    public ResultEntity update(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        if(mUserDao.updateByPrimaryKeySelective(userEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("修改成功");
        }else{
            resultEntity.setMessage("修改失败");
        }
        return resultEntity;
    }

    /**
     * 找回密码
     *
     * @param userEntity
     * @return
     */
    @Override
    public ResultEntity findPwd(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null || userEntity.getRecno()==null || userEntity.getPwd()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        if(mUserDao.updatePwd(userEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("找回密码成功");
        }else{
            resultEntity.setMessage("找回密码失败");
        }
        return resultEntity;
    }

    /**
     * 修改密码
     *
     * @param userEntity
     * @return
     */
    @Override
    public ResultEntity revisePwd(UserEntity userEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userEntity == null || userEntity.getRecno()==null || userEntity.getPwd()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        if(mUserDao.updatePwd(userEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("修改密码成功");
        }else{
            resultEntity.setMessage("修改密码失败");
        }
        return resultEntity;
    }
}
