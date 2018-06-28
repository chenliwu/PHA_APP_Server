package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.dao.*;
import com.clw.phaapp.entity.*;
import com.clw.phaapp.service.IAskAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 回答问题业务类
 *
 * @author chenliwu
 * @create 2018-03-23 21:26
 **/
@Service
public class AskAnswerServiceImpl implements IAskAnswerService {

    @Autowired
    private AskAnswerDao mAskAnswerDao;

    @Autowired
    private LikeDao mLikeDao;


    @Autowired
    private AskCommentDao mAskCommentDao;

    @Autowired
    private AskDao mAskDao;

    @Autowired
    private MessageDao mMessageDao;


    /**
     * 设置访问次数加1
     *
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity setAskAnswerVisitCount(AskAnswerEntity askAnswerEntity) {
        return null;
    }

    /**
     * 回答问题
     * 回答问题之后，要通知问答发起者有人回答了他的问题
     *
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity insertRecord(AskAnswerEntity askAnswerEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askAnswerEntity.getAskrecno() == null || askAnswerEntity.getUserrecno() == null){
            resultEntity.setMessage("参数不不正确");
            return resultEntity;
        }
        //服务器需要添加：发表时间
        Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        askAnswerEntity.setOptime(opdate);
        int nResult=mAskAnswerDao.insertSelective(askAnswerEntity);
        if(nResult > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("回答问题成功");

            //通知问答发起者有人回答了它的问题
            AskEntity askEntity=mAskDao.selectByPrimaryKey(askAnswerEntity.getAskrecno());
            if(askAnswerEntity!=null){
                MessageEntity messageEntity=new MessageEntity();
                messageEntity.setType((byte)0);
                messageEntity.setReceiver(askEntity.getUserrecno());
                //服务器需要添加：发表时间
                messageEntity.setOpdate(opdate);
                messageEntity.setContent("有人回答了您发起的健康问答《"+askEntity.getTitle()+"》。");
                mMessageDao.insertSelective(messageEntity);
            }

        }else{
            resultEntity.setMessage("回答问题失败");
        }
        //System.out.println("回答问题:"+resultEntity.toString());
        return resultEntity;
    }

    /**
     * 获取已经采纳的回答列表
     *
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity getAskAnswerList(AskAnswerEntity askAnswerEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askAnswerEntity.getAskrecno() == null){
            resultEntity.setMessage("参数不不正确");
            return resultEntity;
        }
        int nTotal = mAskAnswerDao.selectAllAskAnswerTotalByAskRecno(askAnswerEntity);
        askAnswerEntity.setTotal(nTotal);
        if(nTotal > 0){
            askAnswerEntity.setDoAount(false);
            List<AskAnswerEntity> list=mAskAnswerDao.selectAllAskAnswerByAskRecno(askAnswerEntity);

            //判断查询数据的用户是否对回答点赞
            for(int i=0,size=list.size();i<size;i++){
                AskAnswerEntity entity=list.get(i);
                LikeEntity likeEntity=new LikeEntity();
                likeEntity.setTargetrecno(String.valueOf(entity.getRecno()));

                //获取该回答的点赞次数
                entity.setLikecount(mLikeDao.selectLikeCount(likeEntity));

                likeEntity.setUserrecno(askAnswerEntity.getSelectuserreno());
                if(mLikeDao.selectRecordByParam(likeEntity).size() > 0){
                    //用户对该回答点了赞
                    entity.setLike(true);
                }
                list.set(i,entity);

            }
            askAnswerEntity.setRows(list);
        }
        resultEntity.setState(200);
        resultEntity.setData(askAnswerEntity);
        //System.out.println("获取回答列表:"+resultEntity.toString());
        return resultEntity;
    }


    /**
     * 查询回答列表，分页
     *
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity selectAskAnswerByPage(AskAnswerEntity askAnswerEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askAnswerEntity.getAskrecno() == null){
            resultEntity.setMessage("参数不不正确");
            return resultEntity;
        }
        int nTotal = mAskAnswerDao.selectAskAnswerTotalByPage(askAnswerEntity);
        askAnswerEntity.setTotal(nTotal);
        if(nTotal > 0){
            askAnswerEntity.setDoAount(false);
            List<AskAnswerEntity> list=mAskAnswerDao.selectAskAnswerByPage(askAnswerEntity);

            //判断查询数据的用户是否对回答点赞
            for(int i=0,size=list.size();i<size;i++){
                AskAnswerEntity entity=list.get(i);
                LikeEntity likeEntity=new LikeEntity();
                likeEntity.setTargetrecno(String.valueOf(entity.getRecno()));

                //获取该回答的点赞次数
                entity.setLikecount(mLikeDao.selectLikeCount(likeEntity));

                likeEntity.setUserrecno(askAnswerEntity.getSelectuserreno());
                if(mLikeDao.selectRecordByParam(likeEntity).size() > 0){
                    //用户对该回答点了赞
                    entity.setLike(true);
                }
                list.set(i,entity);

            }
            askAnswerEntity.setRows(list);
        }
        resultEntity.setState(200);
        resultEntity.setData(askAnswerEntity);
        //System.out.println("获取回答列表，分页:"+resultEntity.toString());
        return resultEntity;
    }

    /**
     * 采纳回答
     * status 状态：0未采纳，1已采纳
     * 采纳成功后，给问题回答发送一条消息
     *
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity acceptAskAnswer(AskAnswerEntity askAnswerEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askAnswerEntity.getRecno() == null){
            resultEntity.setMessage("参数不正确");
            return resultEntity;
        }
        //System.out.println("采纳回答:"+askAnswerEntity.toString());
        askAnswerEntity.setStatus((byte)1);
        if(mAskAnswerDao.updateByPrimaryKeySelective(askAnswerEntity) > 0){

            if(askAnswerEntity.getUserrecno()!=null){
                AskEntity askEntity=mAskDao.selectByPrimaryKey(askAnswerEntity.getAskrecno());
                if(askEntity!=null){
                    //需要的字段：用户记录号、消息内容
                    MessageEntity messageEntity=new MessageEntity();
                    messageEntity.setReceiver(askAnswerEntity.getUserrecno());
                    //系统通知
                    messageEntity.setType((byte)0);
                    //服务器需要添加：操作时间
                    Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
                    messageEntity.setOpdate(opdate);
                    messageEntity.setContent("你的回答已被采纳！（问答标题："+askEntity.getTitle()+"）");
                    mMessageDao.insertSelective(messageEntity);
                }

            }


            resultEntity.setState(200);
            resultEntity.setMessage("操作成功");
        }else{
            resultEntity.setMessage("操作失败");
        }
        return resultEntity;
    }

    /**
     * 删除回答
     * 删除指定回答后，与该回答相关的点赞和评论记录都要删除
     * @param askAnswerEntity
     * @return
     */
    @Override
    public ResultEntity deleteAskAnswer(AskAnswerEntity askAnswerEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(askAnswerEntity.getRecno() == null){
            resultEntity.setMessage("参数不正确");
            return resultEntity;
        }

       // System.out.println("删除回答:"+askAnswerEntity.toString());

        if(mAskAnswerDao.deleteByPrimaryKey(askAnswerEntity.getRecno()) > 0){

            //删除点赞相关的记录
            LikeEntity likeEntity=new LikeEntity();
            likeEntity.setTargetrecno(askAnswerEntity.getRecno().toString());
            mLikeDao.deleteRecordsByParam(likeEntity);

            //删除评论相关的记录
            AskCommentEntity askCommentEntity=new AskCommentEntity();
            askCommentEntity.setTargetrecno(askAnswerEntity.getRecno().toString());
            mAskCommentDao.deleteRecordsByParam(askCommentEntity);

            resultEntity.setState(200);
            resultEntity.setMessage("删除回答成功");
        }else {
            resultEntity.setMessage("删除回答失败");
        }
        return resultEntity;
    }

    /**
     * 点赞回答
     * 点赞需要的字段：回答记录号，点赞者记录号，点赞类型，操作时间
     * 点赞成功后，需要给问答回答者发送一条消息
     * @param likeEntity
     * @return
     */
    @Override
    public ResultEntity like(LikeEntity likeEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(likeEntity.getTargetrecno() == null || likeEntity.getUserrecno() == null){
            resultEntity.setMessage("参数不正确");
            return resultEntity;
        }
        //type = 0 点赞回答
        likeEntity.setType((byte)0);
        //服务器需要添加：发表时间
        Long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        likeEntity.setOpdate(opdate);
        if(mLikeDao.insertSelective(likeEntity) > 0){
            resultEntity.setMessage("点赞成功");
            resultEntity.setState(200);

            //AskAnswerEntity askAnswerEntity;

        }else{
            resultEntity.setMessage("点赞失败");
        }
        //System.out.println("点赞回答："+resultEntity.toString());
        return resultEntity;
    }
}
