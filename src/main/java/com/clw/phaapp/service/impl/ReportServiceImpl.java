package com.clw.phaapp.service.impl;

import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.common.utils.TimeUtils;
import com.clw.phaapp.dao.ReportDao;
import com.clw.phaapp.entity.ReportEntity;
import com.clw.phaapp.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 举报业务
 * @author chenliwu
 * @create 2018-04-08 0:32
 **/
@Service
public class ReportServiceImpl implements IReportService{

    @Autowired
    private ReportDao mReportDao;

    /**
     * 添加举报记录
     *
     * @param reportEntity
     * @return
     */
    @Override
    public ResultEntity insertRecord(ReportEntity reportEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(reportEntity.getTargetrecno()==null || reportEntity.getUserrecno() == null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        //System.out.println("添加举报记录:"+reportEntity.toString());
        long opdate=Long.parseLong(TimeUtils.getCurrentTime_5());
        reportEntity.setOpdate(opdate);
        if(mReportDao.insertSelective( reportEntity) >0){
            resultEntity.setMessage("感谢您的反馈，我们会尽快处理");
            resultEntity.setState(200);
        }else{
            resultEntity.setMessage("举报失败");
        }

        return resultEntity;
    }

    /**
     * 分页查询，举报记录
     *
     * @param reportEntity
     * @return
     */
    @Override
    public ResultEntity selectRecordsByPage(ReportEntity reportEntity) {
        ResultEntity resultEntity=new ResultEntity();
        int nTotal=mReportDao.selectRecordsTotalByPage(reportEntity);
        reportEntity.setTotal(nTotal);
        reportEntity.setDoAount(false);
        List<ReportEntity> list=mReportDao.selectRecordsByPage(reportEntity);
        reportEntity.setRows(list);
        resultEntity.setState(200);
        resultEntity.setData(reportEntity);
        return resultEntity;
    }

    /**
     * 修改举报记录
     *
     * @param reportEntity
     * @return
     */
    @Override
    public ResultEntity updateRecord(ReportEntity reportEntity) {
        ResultEntity resultEntity=new ResultEntity();
        if(reportEntity.getRecno() == null || reportEntity.getTargetrecno()==null || reportEntity.getUserrecno() == null){
            resultEntity.setMessage("参数错误");
            return resultEntity;
        }
        if(mReportDao.updateByPrimaryKeySelective(reportEntity) > 0){
            resultEntity.setMessage("处理举报成功");
            resultEntity.setState(200);
        }else{
            resultEntity.setMessage("处理举报失败");
        }
        return resultEntity;
    }
}
