package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgGroup;
import com.yyb.mapper.ImgCategoryMapper;
import com.yyb.mapper.ImgGroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ImgGroupService {

    @Autowired
    private ImgGroupMapper imgGroupMapper;

    public PageInfo<ImgGroup> queryImgGroupList(int page , int pageSize){
        PageHelper.startPage(page,pageSize);
        List<ImgGroup> imgGroupList =  imgGroupMapper.queryImgGroupList();
        PageInfo<ImgGroup> pageImgGroupList = new PageInfo<ImgGroup>(imgGroupList);
        return pageImgGroupList;
    }

    //添加图片类别
    public int addImgGroup(ImgGroup ig){
        return imgGroupMapper.addImgGroup(ig);
    }

    //删除图片类别
    public int deleteImgGroup(int id){
        return imgGroupMapper.deleteImgGroup(id);
    }

    //根据id查询图片类别信息
    public ImgGroup queryImgGroupBeanById(int id){
        return imgGroupMapper.queryImgGroupBeanById(id);
    }

    //修改图片类别
    public int updateImgGroup(ImgGroup ig){
        return imgGroupMapper.updateImgGroup(ig);
    }

    //根据类别id查询所有图片组
    public List<ImgGroup> queryImgGroupListByCatId(int catId){return imgGroupMapper.queryImgGroupListByCatId(catId);}

}
