package com.clw.phaapp.common.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * 日志工具类
 * <p>error 以及  all 方法产生的日志会存到同一个文件
 * <p>同时error产生的日志还会另外保存到单独的文件
 * <p>info、debug产生的日志都是保存到单独的日志文件中
 * <p>
 * <p>2016年3月16日 下午3:41:45
 *
 * @author hjc
 */
@SuppressWarnings("unused")
public class LogUtils {
    public static void main(String[] args) {
        //AntPathMatcher matcher=new AntPathMatcher();
    }

    /**
     * 所有日志
     */
    private static Logger allLogger = Logger.getLogger("allLogger");
    /**
     * 普通日志
     */
    private static Logger infoLogger = Logger.getLogger("infoLogger");
    /**
     *   调试日志
     */
    private static Logger debugLogger = Logger.getLogger("debugLogger");


    public static void all(Exception e) {
        allLogger.info("", e);
    }

    public static void all(String message) {
        allLogger.info(message);
    }

    public static void all(String message, Exception e) {
        allLogger.info(message, e);
    }


    public static void error(Exception e) {
        allLogger.error("", e);
    }

    public static void error(String message) {
        allLogger.error(message);
    }

    public static void error(String message, Exception e) {
        allLogger.error(message, e);
    }

    /**
     *  普通日志
     */
    public static void info(Exception e) {
        infoLogger.info("", e);
    }

    public static void info(String message) {
        infoLogger.info(message);
    }

    public static void info(String message, Exception e) {
        infoLogger.info(message, e);
    }


    /**
     * 调试日志
     */
    public static void debug(Exception e) {
        debugLogger.debug("", e);
    }

    public static void debug(String message) {
        debugLogger.debug(message);
    }

    public static void debug(String message, Exception e) {
        debugLogger.debug(message, e);
    }

    public static void logOnFile(String fileName, String logInfo) {
        if (logInfo == null || "".equals(logInfo)) {
            return;
        }
        try {
            File f = new File(fileName);
            if (f.exists()) {
                FileUtils.writeStringToFile(f, logInfo, "UTF-8", true);
            } else {
                FileUtils.writeStringToFile(f, logInfo, "UTF-8", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
