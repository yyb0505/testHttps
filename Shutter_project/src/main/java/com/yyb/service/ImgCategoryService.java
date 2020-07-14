package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.Users;
import com.yyb.mapper.ImgCategoryMapper;
import com.yyb.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ImgCategoryService {

    @Autowired
    private ImgCategoryMapper imgCategoryMapper;

    //分页查询图片类别
    public PageInfo<ImgCategory> queryImgCategoryList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<ImgCategory> imgCategoryList =  imgCategoryMapper.queryImgCategoryList();
        PageInfo<ImgCategory> pageImgCategoryList = new PageInfo<ImgCategory>(imgCategoryList);
        return pageImgCategoryList;
    }

    //添加图片类别
    public int addImgCategory(ImgCategory ic){
        return imgCategoryMapper.addImgCategory(ic);
    }

    //删除图片类别
    public int deleteImgCategory(int id){
        return imgCategoryMapper.deleteImgCategory(id);
    }

    //根据id查询图片类别信息
    public ImgCategory queryImgCategoryBeanById(int id){
        return imgCategoryMapper.queryImgCategoryBeanById(id);
    }
    //修改图片类别
    public int updateImgCategory(ImgCategory ic){
        return imgCategoryMapper.updateImgCategory(ic);
    }

    //根据类型查询类别信息列表
    public List<ImgCategory> queryImgCategoryListByType(int type){
        return imgCategoryMapper.queryImgCategoryListByType(type);
    }

}
