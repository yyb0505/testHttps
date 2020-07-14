package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgSlideShow;
import com.yyb.service.ImgCategoryService;
import com.yyb.service.ImgSlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ImgSlideShowService imgSlideShowService;
    @Autowired
    private ImgCategoryService imgCategoryService;


    @RequestMapping("/index")
    public String index(Model model){
        //查询轮播图
        List<ImgSlideShow> issp =  imgSlideShowService.queryPlayShowList();
        model.addAttribute("issp", JSON.toJSONString(issp));
        //查询类别信息--热门
        List<ImgCategory> hotCategory= imgCategoryService.queryImgCategoryListByType(1);
        model.addAttribute("hotCategory", JSON.toJSONString(hotCategory));
        //查询类别信息--普通
        List<ImgCategory> commCategory= imgCategoryService.queryImgCategoryListByType(0);
        model.addAttribute("commCategory", JSON.toJSONString(commCategory));

        return "views/index";
    }
}
