package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.dao.LogDao;
import com.clw.phaapp.entity.LogEntity;
import com.clw.phaapp.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 日志业务
 *
 * @author chenliwu
 * @create 2018-03-20 23:29
 **/
@Service
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogDao mLogDao;

    /**
     * 插入一条访问日志
     *
     * @param logEntity
     * @return
     */
    @Override
    public ResultEntity insertLogRecord(LogEntity logEntity) {
        ResultEntity resultEntity=new ResultEntity();
        int nResult=mLogDao.insertSelective(logEntity);
        if(nResult > 0){
            resultEntity.setState(200);
            resultEntity.setMessage("插入访问日志成功");
        }
        //System.out.println("插入日志："+resultEntity.toString());
        return resultEntity;
    }


    /**
     * 查询访问日志，获取浏览历史
     *
     * @param logEntity
     * @return
     */
    @Override
    public ResultEntity selectVisitHistoryRecordsByPage(LogEntity logEntity) {
        System.out.println("获取浏览历史参数:"+logEntity.toString());
        ResultEntity resultEntity=new ResultEntity();
        if(logEntity ==null || logEntity.getUserrecno() == null){
            resultEntity.setMessage("客户端提交参数不正确");
            return resultEntity;
        }
        int nTotal=mLogDao.selectVisitHistoryRecordsTotalByPage(logEntity);
        logEntity.setDoAount(false);
        List<LogEntity> list=mLogDao.selectVisitHistoryRecordsByPage(logEntity);

        List<LogEntity> rows=new ArrayList<>();
        Set<String> mDataSet=new HashSet<>();
        for(LogEntity entity:list){
            if(mDataSet.contains(entity.getTargetrecno())){
                //剔除重复记录
                rows.add(entity);
                mDataSet.add(entity.getTargetrecno());
            }
        }
        logEntity.setTotal(rows.size());
        logEntity.setRows(rows);
        resultEntity.setState(200);
        resultEntity.setData(logEntity);
        //System.out.println("获取浏览历史结果："+resultEntity.toString());
        return resultEntity;
    }
}
