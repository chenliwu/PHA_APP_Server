package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.dao.UserFeedbackDao;
import com.clw.phaapp.entity.UserFeedbackEntity;
import com.clw.phaapp.service.IUserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFeedbackServiceImpl implements IUserFeedbackService {

    @Autowired
    private UserFeedbackDao mUserFeedbackDao;

    /**
     * 插入记录
     *
     * @param userFeedbackEntity
     * @return
     */
    @Override
    public ResultEntity insertRecord(UserFeedbackEntity userFeedbackEntity) {
        ResultEntity resultEntity=new ResultEntity();
        System.out.println("插入反馈记录："+userFeedbackEntity.toString());
        if(mUserFeedbackDao.insertSelective(userFeedbackEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("感谢您的反馈，我们将不断改进");
        }else{
            resultEntity.setMessage("反馈失败");
        }
        return resultEntity;
    }
}
