package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommPicture;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.CommPictureService;
import com.yyb.util.UploadFileUtil;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class CommPictureController {

    @Autowired
    private CommPictureService commPictureService;

    //请求动态图片界面
    @RequestMapping("/commPictureTables")
    public String commPictureTables(){
        return "bsmanager/tables/commPictureTables";
    }

    //分页查询动态图片
    @ResponseBody
    @RequestMapping("/queryCommPictureList")
    public RespTableBean<CommPicture> queryCommPictureList(int page, int pageSize){
        PageInfo<CommPicture> commPictureList = commPictureService.queryCommPictureList(page,pageSize);
        RespTableBean<CommPicture> rb = new RespTableBean<CommPicture>(RespTableBean.SUCCESS,"查询成功！",commPictureList.getTotal(),commPictureList.getList());
        return rb;
    }

    //请求动态图片添加界面
    @RequestMapping("/commPictureAdd")
    public String commPictureAdd(){
        return "bsmanager/forms/commPictureAdd";
    }

    //动态图片添加
    @ResponseBody
    @RequestMapping(value = "/addCommPicture",method = RequestMethod.POST)
    public RespBean addCommPicture(CommPicture ic,@RequestParam MultipartFile file){
        RespBean rb = new RespBean();
        try {

            if(file.isEmpty()){
                rb.setCode(RespBean.ERROR);
                rb.setMsg("动态图片为空！");
            }else{

                Map<String,Object> map = UploadFileUtil.UploadFile(file);
                ic.setPicNumber(UUID.randomUUID().toString().replace("-",""));
                ic.setPicPath((String)map.get("path"));
                ic.setPicSize((long)map.get("size"));
                ic.setPicType((String)map.get("type"));
                int rps = commPictureService.addCommPicture(ic);
                if(rps > 0){
                    rb.setCode(RespBean.SUCCESS);
                    rb.setMsg("动态图片添加成功！");
                }else{
                    rb.setCode(RespBean.ERROR);
                    rb.setMsg("动态图片添加失败！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态图片添加失败！");
        }
        return rb;

    }


    //动态图片删除
    @ResponseBody
    @RequestMapping("/deleteCommPicture")
    public RespBean deleteCommPicture(int id){
        RespBean rb = new RespBean();
        int rps = commPictureService.deleteCommPicture(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态图片删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态图片删除失败！");
        }
        return rb;
    }

    //请求动态图片修改页面
    @RequestMapping("/commPictureUpdate")
    public String commPictureUpdate(Model model, int id){
        CommPicture ip = commPictureService.queryCommPictureBeanById(id);
        model.addAttribute("ip",JSON.toJSONString(ip));
        return "bsmanager/forms/commPictureUpdate";
    }

    @ResponseBody
    @RequestMapping("/updateCommPicture")
    public RespBean updateCommPicture(CommPicture ic){
        RespBean rb = new RespBean();
        int rps = commPictureService.updateCommPicture(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态图片修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态图片修改失败！");
        }
        return rb;
    }
}
