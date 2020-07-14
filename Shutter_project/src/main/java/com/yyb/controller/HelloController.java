package com.yyb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
   // @Value("${http_url}")
    private String httpUrl = "5";

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
       //logger.info("springboot 集成logger 日志成功！");
       return "HelloWorld!";
    }

    @ResponseBody
    @RequestMapping("/getUrl")
    public String getHttpUrl(){
        return httpUrl;
    }

    @ResponseBody
    @RequestMapping("/getUrl2")
    public String getHttpUrl2(){
        return httpUrl;
    }
}
