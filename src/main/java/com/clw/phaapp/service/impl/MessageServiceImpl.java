package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.dao.MessageDao;
import com.clw.phaapp.entity.MessageEntity;
import com.clw.phaapp.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenliwu
 * @create 2018-04-10 10:38
 **/
@Service
public class MessageServiceImpl implements IMessageService{

    @Autowired
    private MessageDao mMessageDao;


    /**
     * 分页查询消息记录
     *
     * @param messageEntity
     * @return
     */
    @Override
    public ResultEntity selectRecordsListByPage(MessageEntity messageEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(messageEntity.getReceiver() == null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        System.out.println("page:"+messageEntity.getPage());
        int nTotal=mMessageDao.selectRecordsTotalByPage(messageEntity);
        messageEntity.setTotal(nTotal);
        if(nTotal > 0){
            messageEntity.setDoAount(false);
            List<MessageEntity> list=mMessageDao.selectRecordsListByPage(messageEntity);
            messageEntity.setRows(list);

            for(MessageEntity entity:list){
                System.out.println(entity.toString());
            }

            resultEntity.setState(200);
        }else{
            resultEntity.setMessage("暂无消息");
        }
        resultEntity.setData(messageEntity);
        //System.out.println("分页查询消息记录:"+resultEntity.toString());
        return resultEntity;
    }

    /**
     * 修改消息状态，将消息修改成已读
     *
     * @param messageEntity
     * @return
     */
    @Override
    public ResultEntity updateRecord(MessageEntity messageEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(messageEntity.getReceiver() == null ){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        if(mMessageDao.updateRecordsStatusByParam(messageEntity) > 0){
            resultEntity.setState(200);
        }
        return resultEntity;
    }


    /**
     * 将消息列表标为已读
     *
     * @param messageEntity
     * @return
     */
    @Override
    public ResultEntity updateMessageStatusByParam(MessageEntity messageEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(messageEntity.getUpdateStatusMessageRecnolist()==null){
            resultEntity.setMessage("参数错误");
            return  resultEntity;
        }
        System.out.println("将消息列表标为已读:"+messageEntity.toString());
        String updateStatusMessageRecnolist=messageEntity.getUpdateStatusMessageRecnolist();
        String[] ids=updateStatusMessageRecnolist.split(",");
        if(ids.length > 0){
            //将消息列表标为已读
            for(int i=0;i<ids.length;i++){
                //消息记录号
                Long messageRecno=Long.parseLong(ids[i]);
                MessageEntity entity=new MessageEntity();
                entity.setRecno(messageRecno);
                //状态：0未读，1已读
                entity.setStatus((byte)1);
                mMessageDao.updateByPrimaryKeySelective(entity);
            }
            resultEntity.setState(200);
        }else{

        }
        return resultEntity;
    }

    /**
     * 根据参数获取消息记录数
     * 只查询未阅读的记录数
     *
     * @param messageEntity
     * @return
     */
    @Override
    public ResultEntity selectMessageTotalByParam(MessageEntity messageEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(messageEntity.getReceiver() == null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        //只查询未阅读的记录数
        messageEntity.setStatus((byte)0);
        int nTotal=mMessageDao.selectRecordsTotalByPage(messageEntity);
        resultEntity.setData(nTotal);
        resultEntity.setState(200);
        return resultEntity;
    }
}
