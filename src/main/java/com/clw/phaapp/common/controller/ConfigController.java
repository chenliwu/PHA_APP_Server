package com.clw.phaapp.common.controller;

import com.clw.phaapp.common.utils.P6SpyLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设置相关controller
 * Created by Administrator on 2017/12/2.
 *
 * @author hjc
 */
@RequestMapping("/config")
@Controller
public class ConfigController {
    private static final String CONFIG_FALSE = "false";
    private static final String CONFIG_TRUE = "true";

    /**
     * 切换是否打印SQL
     *
     * @param v
     * @return
     */
    @RequestMapping("/printSQL")
    @ResponseBody
    public String printSQLChange(String v) {
        if (CONFIG_FALSE.equals(v)) {
            P6SpyLogger.printSQL = false;
            return "printSQL:" + CONFIG_FALSE;
        }
        if (CONFIG_TRUE.equals(v)) {
            P6SpyLogger.printSQL = true;
            return "printSQL:" + CONFIG_TRUE;
        }
        return "nothing change, printSQL:" + P6SpyLogger.printSQL;
    }
}
