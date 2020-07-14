package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgGroup;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.ImgCategoryService;
import com.yyb.service.ImgGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImgGroupController {

    @Autowired
    private ImgGroupService imgGroupService;

    @Autowired
    private ImgCategoryService imgCategoryService;

    //请求图片组界面
    @RequestMapping("/imgGroupTables")
    public String imgGroupTables(){
        return "bsmanager/tables/imgGroupTables";
    }

    //分页查询图片组
    @ResponseBody
    @RequestMapping("/queryImgGroupList")
    public RespTableBean<ImgGroup> queryImgGroupList(int page, int pageSize){
        PageInfo<ImgGroup> imgGroupList = imgGroupService.queryImgGroupList(page,pageSize);
        RespTableBean<ImgGroup> rb = new RespTableBean<ImgGroup>(RespTableBean.SUCCESS,"查询成功！",imgGroupList.getTotal(),imgGroupList.getList());
        return rb;
    }

    //请求图片组添加界面
    @RequestMapping("/imgGroupAdd")

    public String imgGroupAdd(){
        return "bsmanager/forms/imgGroupAdd";
    }

    //图片组添加
    @ResponseBody
    @RequestMapping("/addImgGroup")
    public RespBean addImgGroup(ImgGroup ig){
        RespBean rb = new RespBean();
        int rps = imgGroupService.addImgGroup(ig);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片组添加成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片组添加失败！");
        }
        return rb;
    }

    //图片组删除
    @ResponseBody
    @RequestMapping("/deleteImgGroup")
    public RespBean deleteImgGroup(int id){
        RespBean rb = new RespBean();
        int rps = imgGroupService.deleteImgGroup(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片组删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片组删除失败！");
        }
        return rb;
    }

    //请求轮播图修改页面
    @RequestMapping("/imgGroupUpdate")
    public String imgCategoryUpdate(Model model, int id){
        ImgGroup ig = imgGroupService.queryImgGroupBeanById(id);
        model.addAttribute("ig",JSON.toJSONString(ig));
        return "bsmanager/forms/imgGroupUpdate";
    }

    @ResponseBody
    @RequestMapping("/updateImgGroup")
    public RespBean updateImgCategory(ImgGroup ig){
        RespBean rb = new RespBean();
        int rps = imgGroupService.updateImgGroup(ig);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("图片组修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("图片组修改失败！");
        }
        return rb;
    }

    //根据类别id查询所有图片组
    @RequestMapping("/queryImgGroupListByCatId")
    public String queryImgGroupListByCatId(Model model, int catId){
        List<ImgGroup> groupList = imgGroupService.queryImgGroupListByCatId(catId);
        ImgCategory  imgCategoryInfo = imgCategoryService.queryImgCategoryBeanById(catId);
        model.addAttribute("groupList",JSON.toJSONString(groupList));
        model.addAttribute("categoryInfo",JSON.toJSONString(imgCategoryInfo));
        return "views/groupList";
    }
}
