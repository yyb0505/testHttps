package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgSlideShow;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.ImgSlideShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ImgSlideShowController {

    @Autowired
    private ImgSlideShowService imgSlideShowService;

    //请求轮播图表格页面
    @RequestMapping("/slideShowTables")
    public String slideShowTables(){
        return "bsmanager/tables/slideShowTables";
    }

    //请求轮播图更新页面
    @RequestMapping("/slideShowUpdate")
    public String slideShowUpdate(Model model, int id){
        ImgSlideShow iss = imgSlideShowService.queryImgSlideShowBeanById(id);
        model.addAttribute("issb", JSON.toJSONString(iss));
        return "bsmanager/forms/slideShowUpdate";
    }

    //请求轮播图添加页面
    @RequestMapping("/slideShowAdd")
    public String slideShowAdd(){
        return "bsmanager/forms/slideShowAdd";
    }

    //查询轮播图列表
    @ResponseBody
    @RequestMapping("/queryImgSlideShowList")
    public RespTableBean<ImgSlideShow> queryUsersList(int page, int pageSize){
        PageInfo<ImgSlideShow> usersList =  imgSlideShowService.queryImgSlideShowList(page,pageSize);
        RespTableBean<ImgSlideShow> rb = new RespTableBean<ImgSlideShow>(0,"success",usersList.getTotal(),usersList.getList());
        return rb;
    }

    //轮播图编辑
    @ResponseBody
    @RequestMapping("/updateImgSlideShow")
    public RespBean updateImgSlideShow(ImgSlideShow iss){
        RespBean rb = new RespBean();
        int rps = imgSlideShowService.updateImgSlideShow(iss);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("轮播图信息修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("轮播图信息修改失败！");
        }
        return rb;
    }

    //轮播图删除
    @ResponseBody
    @RequestMapping("/deleteImgSlideShow")
    public RespBean deleteImgSlideShow(int id){
        RespBean rb = new RespBean();
        int rps = imgSlideShowService.deleteImgSlideShow(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("删除轮播图成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("删除轮播图失败！");
        }
        return rb;
    }

    //轮播图添加
    @ResponseBody
    @RequestMapping("/addImgSlideShow")
    public RespBean addImgSlideShow(ImgSlideShow iss){
        RespBean rb = new RespBean();
        int rps = imgSlideShowService.addImgSlideShow(iss);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("添加轮播图成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("添加轮播图失败！");
        }
        return rb;
    }

}
