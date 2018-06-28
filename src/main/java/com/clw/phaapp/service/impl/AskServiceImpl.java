package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.dao.AskAnswerDao;
import com.clw.phaapp.dao.AskDao;
import com.clw.phaapp.entity.AskAnswerEntity;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.entity.UserCollectionEntity;
import com.clw.phaapp.service.IAskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 健康问答业务实现类
 *
 * @author chenliwu
 * @create 2018-03-08 22:36
 **/
@Service
public class AskServiceImpl  implements IAskService{

    @Autowired
    private AskDao mAskDao;

    @Autowired
    private AskAnswerDao mAskAnswerDao;


    /**
     * 设置问答访问次数加1
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity setAskVisitCount(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askEntity == null || askEntity.getRecno()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        //System.out.println("设置问答访问次数加1："+askEntity.toString());
        int nResult=mAskDao.setAskVisitCount(askEntity);
        if(nResult > 0){
            resultEntity.setState(200);
        }
        return resultEntity;
    }

    /**
     * 发起健康问答
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity publishAsk(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askEntity == null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        //服务器需要添加：发表时间
        Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        askEntity.setOpdate(opdate);
        if(mAskDao.insertSelective(askEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("发起问答成功，请等待审核通过");
        }else{
            resultEntity.setMessage("发起失败");
        }
        return resultEntity;
    }

    /**
     * 删除健康问答
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity deleteAsk(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askEntity == null || askEntity.getRecno()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        if(mAskDao.deleteByPrimaryKey(askEntity.getRecno()) > 0){
            //删除问题记录后，还要删除相关的回答记录
            AskAnswerEntity askAnswerEntity=new AskAnswerEntity();
            askAnswerEntity.setAskrecno(askEntity.getRecno());
            mAskAnswerDao.deleteAnswerRecordsByParam(askAnswerEntity);
            resultEntity.setState(200);
            resultEntity.setMessage("删除成功");
        }else{
            resultEntity.setMessage("删除失败");
        }
        System.out.println("删除健康问答："+resultEntity.toString());
        return resultEntity;
    }

    /**
     * 修改健康问答
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity reviseAsk(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askEntity == null || askEntity.getRecno()==null){
            resultEntity.setMessage("客户端提交数据异常");
            return resultEntity;
        }
        //服务器需要添加：发表时间
        Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        askEntity.setOpdate(opdate);
        if(mAskDao.updateByPrimaryKeySelective(askEntity) > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("修改成功");
        }else{
            resultEntity.setMessage("修改失败");
        }
        return resultEntity;
    }

    /**
     * 获取健康问答列表，分页
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity selectAskRecordListByPage(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        //选择已经通过审核的健康问答列表
        int nTotal=mAskDao.selectAskRecordListTotalByPage(askEntity);
        askEntity.setTotal(nTotal);
        askEntity.setDoAount(false);
        List<AskEntity> list=mAskDao.selectAskRecordListByPage(askEntity);

        if(askEntity.getStatus()!=null && askEntity.getStatus()==1){

            //获取问题的回答列表个数（回答总数、采纳回答总数）
            for(int i=0,size=list.size();i<size;i++){
                Long askrecno=list.get(i).getRecno();
                //获取回答总数
                list.get(i).setAllanswercount(mAskAnswerDao.selectAllAskAnswerCount(askrecno));
                //获取问题的采纳回答总数
                list.get(i).setAcceptanswercount(mAskAnswerDao.selectAcceptAskAnswerCount(askrecno));
            }
        }

        askEntity.setRows(list);
        resultEntity.setData(askEntity);
        resultEntity.setState(200);
        return resultEntity;
    }

    /**
     * 获取单条健康问答明细
     *
     * @param askEntity
     * @return
     */
    @Override
    public ResultEntity selectOneAskRecord(AskEntity askEntity) {
        ResultEntity resultEntity=new ResultEntity();
        AskEntity entity=mAskDao.selectOneAskRecord(askEntity);
        if(entity!=null){
            resultEntity.setState(200);
            //获取回答总数
            entity.setAllanswercount(mAskAnswerDao.selectAllAskAnswerCount(entity.getRecno()));
            //获取问题的采纳回答总数
            entity.setAcceptanswercount(mAskAnswerDao.selectAcceptAskAnswerCount(entity.getRecno()));
            resultEntity.setData(entity);
        }else{
            resultEntity.setMessage("没有数据");
        }
        //System.out.println("获取单条健康问答明细:"+resultEntity.toString());
        return resultEntity;
    }
}
