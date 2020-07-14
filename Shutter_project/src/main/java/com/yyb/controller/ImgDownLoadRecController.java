package com.yyb.controller;

import com.yyb.entity.ImgDownLoadRec;
import com.yyb.entity.RespBean;
import com.yyb.mapper.ImgDownLoadRecMapper;
import com.yyb.service.ImgDownLoadRecService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class ImgDownLoadRecController {

    @Autowired
    private ImgDownLoadRecService imgDownLoadRecService;

    @RequestMapping("/imgDownLoadRecChart")
    public String imgDownLoadRecChart(){
        return "bsmanager/tables/imgDownLoadRecChart";
    }

    @ResponseBody
    @RequestMapping("/queryImgDownLoadRec")
    public Map<String , Object> queryImgDownLoadRec(int num){
        Map<String , Object> downLoadRecMap =  imgDownLoadRecService.queryImgDownLoadRec(num);
        return downLoadRecMap;
    }

    @ResponseBody
    @RequestMapping("/queryImgDownLoadRecByName")
    public Map<String , Object> queryImgDownLoadRecByName(int num,String userName){
        Map<String , Object> downLoadRecMap =  imgDownLoadRecService.queryImgDownLoadRecByName(num,userName);
        return downLoadRecMap;
    }

    //添加图片下载记录
    @ResponseBody
    @RequestMapping("/insertImgDownLoadRec")
    public RespBean insertImgDownLoadRec(ImgDownLoadRec idlr){
        RespBean rb = new RespBean();
        int rps = imgDownLoadRecService.insertImgDownLoadRec(idlr);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片下载记录添加成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片下载记录添加失败！");
        }
        return rb;
    }
}
