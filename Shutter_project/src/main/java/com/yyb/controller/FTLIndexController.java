package com.yyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FTLIndexController {

    @RequestMapping(value = "/ftlIndexTest")
    public String ftlIndexTest(){
        return "ftlIndex";
    }
}
