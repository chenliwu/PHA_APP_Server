package com.clw.phaapp.common.init;

import com.clw.phaapp.common.utils.P6SpyLogger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 系统初始化执行方法
 * Created by Administrator on 2017/12/2.
 * @author hjc
 */
public class InitSystem implements InitializingBean,ServletContextAware {

    @Value("${printSQL}")
    private boolean printSQL;

    public void afterPropertiesSet() throws Exception {

    }

    public void setServletContext(ServletContext servletContext) {
        System.out.println("系统参数初始化中...");
        P6SpyLogger.printSQL = printSQL;
        System.out.println("设置打印SQL：" + printSQL);
        System.out.println("系统初始化完成");
    }
}
