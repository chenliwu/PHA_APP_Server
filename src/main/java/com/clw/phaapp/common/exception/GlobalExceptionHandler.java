package com.clw.phaapp.common.exception;

import com.clw.phaapp.common.entity.ResultEntity;
import org.apache.log4j.Logger;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Description: <BR>
 * <p>
 * Title: （knowledgewall）<BR>
 *
 * @version 1.0
 * @Author liu.ce
 * ClassName: ExceptionHandler(c)
 * <BR>
 * @Company: <BR>
 * @date 2017/12/28 15:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
//    private final static String EXCEPTION_KEY = "message";


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultEntity handException(Exception e){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setState(200);
        resultEntity.setData(e.getMessage());
        ClassUtils.getShortName(e.getClass() + e.getMessage());
        logger.info(e.getMessage() + e);
        return resultEntity;
    }
//    @ExceptionHandler(SQLException.class)
//    @ResponseBody
//    public ResultEntity handSql(Exception e){
//        ResultEntity resultEntity = new ResultEntity();
//        resultEntity.setState(true);
//        resultEntity.setResult(e.getMessage());
//        logger.info(e.getMessage() + e);
//        return resultEntity;
//    }
//
//    @ExceptionHandler(BluetoothStateException.class)
//    @ResponseBody
//    public ResultEntity handBLException(BluetoothStateException e){
//        ResultEntity resultEntity = new ResultEntity();
//        resultEntity.setState(true);
//        resultEntity.setResult(e.getMessage());
//        return resultEntity;
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public ResultEntity handRTException(RuntimeException e){
//        ResultEntity resultEntity = new ResultEntity();
//        resultEntity.setState(true);
////        resultEntity.setResult();
//        return resultEntity;
//    }
//
//    @ExceptionHandler(IOException.class)
//    @ResponseBody
//    public ResultEntity handIOException(IOException e){
//        ResultEntity resultEntity = new ResultEntity();
//        return resultEntity;
//    }


}