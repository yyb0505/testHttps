package com.yyb.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常
 */
//@ControllerAdvice(basePackages = "com.yyb.controller")
public class GlobalErrorException {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorJSON(){
        Map<String,Object> errorResultMap = new HashMap<String,Object>();
        errorResultMap.put("errorCode","500");
        errorResultMap.put("errorMsg","系统错误！");
        return errorResultMap;
    }
}
