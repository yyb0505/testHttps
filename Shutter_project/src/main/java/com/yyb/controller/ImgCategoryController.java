package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgSlideShow;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.ImgCategoryService;
import com.yyb.service.ImgSlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImgCategoryController {

    @Autowired
    private ImgCategoryService imgCategoryService;

    //请求图片类别界面
    @RequestMapping("/imgCategoryTables")
    public String imgCategoryTables(){
        return "bsmanager/tables/imgCategoryTables";
    }

    //分页查询图片类别
    @ResponseBody
    @RequestMapping("/queryImgCategoryList")
    public RespTableBean<ImgCategory> queryImgCategoryList(int page, int pageSize){
        PageInfo<ImgCategory> imgCategoryList = imgCategoryService.queryImgCategoryList(page,pageSize);
        RespTableBean<ImgCategory> rb = new RespTableBean<ImgCategory>(RespTableBean.SUCCESS,"查询成功！",imgCategoryList.getTotal(),imgCategoryList.getList());
        return rb;
    }

    //请求轮播图添加界面
    @RequestMapping("/imgCategoryAdd")
    public String imgCategoryAdd(){
        return "bsmanager/forms/imgCategoryAdd";
    }
    //轮播图添加
    @ResponseBody
    @RequestMapping("/addImgCategory")
    public RespBean addImgCategory(ImgCategory ic){
        RespBean rb = new RespBean();
        int rps = imgCategoryService.addImgCategory(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片类别添加成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片类别添加失败！");
        }
        return rb;
    }

    //轮播图删除
    @ResponseBody
    @RequestMapping("/deleteImgCategory")
    public RespBean deleteImgCategory(int id){
        RespBean rb = new RespBean();
        int rps = imgCategoryService.deleteImgCategory(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片类别删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片类别删除失败！");
        }
        return rb;
    }

    //请求轮播图修改页面
    @RequestMapping("/imgCategoryUpdate")
    public String imgCategoryUpdate(Model model, int id){
        ImgCategory ic = imgCategoryService.queryImgCategoryBeanById(id);
        model.addAttribute("ic",JSON.toJSONString(ic));
        return "bsmanager/forms/imgCategoryUpdate";
    }

    @ResponseBody
    @RequestMapping("/updateImgCategory")
    public RespBean updateImgCategory(ImgCategory ic){
        RespBean rb = new RespBean();
        int rps = imgCategoryService.updateImgCategory(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片类别修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片类别修改失败！");
        }
        return rb;
    }
}
