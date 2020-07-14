package com.yyb.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgGroup;
import com.yyb.entity.ImgPicture;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.ImgGroupService;
import com.yyb.service.ImgPictureService;
import com.yyb.util.UploadFileUtil;
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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class ImgPictureController {

    @Autowired
    private ImgPictureService imgPictureService;

    @Autowired
    private ImgGroupService imgGroupService;

    //请求图片界面
    @RequestMapping("/imgPictureTables")
    public String imgPictureTables(){
        return "bsmanager/tables/imgPictureTables";
    }

    //分页查询图片
    @ResponseBody
    @RequestMapping("/queryImgPictureList")
    public RespTableBean<ImgPicture> queryImgPictureList(int page, int pageSize){
        PageInfo<ImgPicture> imgPictureList = imgPictureService.queryImgPictureList(page,pageSize);
        RespTableBean<ImgPicture> rb = new RespTableBean<ImgPicture>(RespTableBean.SUCCESS,"查询成功！",imgPictureList.getTotal(),imgPictureList.getList());
        return rb;
    }

    //请求图片添加界面
    @RequestMapping("/imgPictureAdd")
    public String imgPictureAdd(){
        return "bsmanager/forms/imgPictureAdd";
    }

    //图片添加
    @ResponseBody
    @RequestMapping(value = "/addImgPicture",method = RequestMethod.POST)
    public RespBean addImgPicture(ImgPicture ip,@RequestParam MultipartFile file){
        RespBean rb = new RespBean();
        try {

            if(file.isEmpty()){
                rb.setCode(RespBean.ERROR);
                rb.setMsg("图片为空！");
            }else{

                Map<String,Object> map = UploadFileUtil.UploadFile(file);
                ip.setPicNumber(UUID.randomUUID().toString().replace("-",""));
                ip.setPicPath((String)map.get("path"));
                ip.setPicSize((long)map.get("size"));
                ip.setPicType((String)map.get("type"));
                int rps = imgPictureService.addImgPicture(ip);
                if(rps > 0){
                    rb.setCode(RespBean.SUCCESS);
                    rb.setMsg("图片添加成功！");
                }else{
                    rb.setCode(RespBean.ERROR);
                    rb.setMsg("图片添加失败！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片添加失败！");
        }
        return rb;

    }


    //图片删除
    @ResponseBody
    @RequestMapping("/deleteImgPicture")
    public RespBean deleteImgPicture(int id){
        RespBean rb = new RespBean();
        int rps = imgPictureService.deleteImgPicture(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片删除失败！");
        }
        return rb;
    }

    //请求图片修改页面
    @RequestMapping("/imgPictureUpdate")
    public String imgPictureUpdate(Model model, int id){
        ImgPicture ip = imgPictureService.queryImgPictureBeanById(id);
        model.addAttribute("ip",JSON.toJSONString(ip));
        return "bsmanager/forms/imgPictureUpdate";
    }

    //图片更新
    @ResponseBody
    @RequestMapping("/updateImgPicture")
    public RespBean updateImgPicture(ImgPicture ic){
        RespBean rb = new RespBean();
        int rps = imgPictureService.updateImgPicture(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片修改失败！");
        }
        return rb;
    }

    //分页查询图片
    @RequestMapping("/queryImgPictureListByGroId")
    public String queryImgPictureListByGroId(Model model,int page, int pageSize ,int groId){
        PageInfo<ImgPicture> imgPictureList = imgPictureService.queryImgPictureListByGroId(page,pageSize,groId);
        model.addAttribute("imgPictureList",JSON.toJSONString(imgPictureList.getList()));
        ImgGroup groupInfo = imgGroupService.queryImgGroupBeanById(groId);
        model.addAttribute("groupInfo",JSON.toJSONString(groupInfo));
        return "views/imgList";
    }
}
