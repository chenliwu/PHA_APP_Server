package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.dao.AskAnswerDao;
import com.clw.phaapp.dao.AskDao;
import com.clw.phaapp.dao.UserCollectionDao;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.entity.UserCollectionEntity;
import com.clw.phaapp.service.IUserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏业务实现类
 * @author chenliwu
 * @create 2018-04-06 12:32
 **/
@Service
public class UserCollectionServiceImpl implements IUserCollectionService{

    @Autowired
    private UserCollectionDao mUserCollectionDao;


    @Autowired
    private AskDao mAskDao;

    @Autowired
    private AskAnswerDao mAskAnswerDao;



    /**
     * 分页查询，健康问答收藏记录
     *
     * @param userCollectionEntity
     * @return
     */
    @Override
    public ResultEntity selectAskCollectionListByPage(UserCollectionEntity userCollectionEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userCollectionEntity.getUserrecno()==null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        int nTotal = mUserCollectionDao.selectRecordsTotalByPage(userCollectionEntity);
        userCollectionEntity.setTotal(nTotal);
        userCollectionEntity.setDoAount(false);
        List<UserCollectionEntity> list=mUserCollectionDao.selectRecordsByPage(userCollectionEntity);

        List asklist=new ArrayList();
        //加载收藏的问答列表
        for(UserCollectionEntity entity:list){
            AskEntity param=new AskEntity();
            param.setRecno(Long.parseLong(entity.getTargetrecno()));

            //查询健康问答的数据
            AskEntity data=mAskDao.selectOneAskRecord(param);
            if(data!=null){
                //获取回答总数
                data.setAllanswercount(mAskAnswerDao.selectAllAskAnswerCount(data.getRecno()));
                //获取问题的采纳回答总数
                data.setAcceptanswercount(mAskAnswerDao.selectAcceptAskAnswerCount(data.getRecno()));
                asklist.add(data);
                System.out.println("收藏的健康问答："+data.toString());
            }
        }
        userCollectionEntity.setAsklist(asklist);
        userCollectionEntity.setRows(list);
        resultEntity.setData(userCollectionEntity);
        resultEntity.setState(200);
        return resultEntity;
    }

    /**
     * 分页查询，健康资讯收藏记录
     *
     * @param userCollectionEntity
     * @return
     */
    @Override
    public ResultEntity selectHealthInfoCollectionListByPage(UserCollectionEntity userCollectionEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userCollectionEntity.getUserrecno()==null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        int nTotal = mUserCollectionDao.selectRecordsTotalByPage(userCollectionEntity);
        userCollectionEntity.setTotal(nTotal);
        userCollectionEntity.setDoAount(false);
        List<UserCollectionEntity> list=mUserCollectionDao.selectRecordsByPage(userCollectionEntity);
        userCollectionEntity.setRows(list);
        resultEntity.setData(userCollectionEntity);
        resultEntity.setState(200);
        return resultEntity;
    }

    /**
     * 添加收藏记录
     *
     * @param userCollectionEntity
     * @return
     */
    @Override
    public ResultEntity insertRecord(UserCollectionEntity userCollectionEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userCollectionEntity.getTargetrecno()==null || userCollectionEntity.getUserrecno()==null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }

        //判断是否已经收藏有该记录
        if(mUserCollectionDao.selectRecordsTotalByPage(userCollectionEntity) > 0){
            if(userCollectionEntity.getType() < 20){
                resultEntity.setMessage("你已经收藏了该资讯");
            }else if(userCollectionEntity.getType() >= 20){
                resultEntity.setMessage("你已经收藏了该问答");
            }
            return resultEntity;
        }

        //服务器需要添加：收藏时间
        Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        userCollectionEntity.setOpdate(opdate);
        if(mUserCollectionDao.insertSelective(userCollectionEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("收藏成功");
        }else{
            resultEntity.setMessage("收藏失败");
        }
        return resultEntity;
    }

    /**
     * 分页查询，收藏记录
     *
     * @param userCollectionEntity
     * @return
     */
    @Override
    public ResultEntity selectRecordsByPage(UserCollectionEntity userCollectionEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userCollectionEntity.getUserrecno()==null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        int nTotal = mUserCollectionDao.selectRecordsTotalByPage(userCollectionEntity);
        userCollectionEntity.setTotal(nTotal);
        userCollectionEntity.setDoAount(false);
        List<UserCollectionEntity> list=mUserCollectionDao.selectRecordsByPage(userCollectionEntity);
        userCollectionEntity.setRows(list);
        resultEntity.setData(userCollectionEntity);
        resultEntity.setState(200);
        return resultEntity;
    }

    /**
     * 删除单条收藏记录
     *
     * @param userCollectionEntity
     * @return
     */
    @Override
    public ResultEntity deleteOneRecord(UserCollectionEntity userCollectionEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(userCollectionEntity.getRecno()==null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        if(mUserCollectionDao.deleteByPrimaryKey(userCollectionEntity.getRecno()) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("取消收藏成功");
        }else{
            resultEntity.setMessage("取消收藏失败");
        }
        return resultEntity;
    }
}
