package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgPicture;
import com.yyb.mapper.ImgCategoryMapper;
import com.yyb.mapper.ImgPictureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ImgPictureService {

    @Autowired
    private ImgPictureMapper imgPictureMapper;

    //分页查询图片类别
    public PageInfo<ImgPicture> queryImgPictureList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<ImgPicture> imgPictureList =  imgPictureMapper.queryImgPictureList();
        PageInfo<ImgPicture> pageImgPictureList = new PageInfo<ImgPicture>(imgPictureList);
        return pageImgPictureList;
    }

    //添加图片类别
    public int addImgPicture(ImgPicture ip){
        return imgPictureMapper.addImgPicture(ip);
    }

    //删除图片类别
    public int deleteImgPicture(int id){
        return imgPictureMapper.deleteImgPicture(id);
    }

    //根据id查询图片类别信息
    public ImgPicture queryImgPictureBeanById(int id){
        return imgPictureMapper.queryImgPictureBeanById(id);
    }
    //修改图片类别Picture
    public int updateImgPicture(ImgPicture ip){
        return imgPictureMapper.updateImgPicture(ip);
    }


    //分页查询图片类别
    public PageInfo<ImgPicture> queryImgPictureListByGroId(int page , int pageSize , int groId){
        PageHelper.startPage(page,pageSize);
        List<ImgPicture> imgPictureList =  imgPictureMapper.queryImgPictureListByGroId(groId);
        PageInfo<ImgPicture> pageImgPictureList = new PageInfo<ImgPicture>(imgPictureList);
        return pageImgPictureList;
    }

}
