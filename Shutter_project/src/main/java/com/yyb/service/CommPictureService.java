package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommPicture;
import com.yyb.mapper.CommPictureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommPictureService {

    @Autowired
    private CommPictureMapper commPictureMapper;

    //分页查询动态图片
    public PageInfo<CommPicture> queryCommPictureList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<CommPicture> commPictureList =  commPictureMapper.queryCommPictureList();
        PageInfo<CommPicture> pageCommPictureList = new PageInfo<CommPicture>(commPictureList);
        return pageCommPictureList;
    }

    //添加动态图片
    public int addCommPicture(CommPicture cp){
        return commPictureMapper.addCommPicture(cp);
    }

    //删除动态图片
    public int deleteCommPicture(int id){
        return commPictureMapper.deleteCommPicture(id);
    }

    //根据id查询动态图片信息
    public CommPicture queryCommPictureBeanById(int id){
        return commPictureMapper.queryCommPictureBeanById(id);
    }

    //修改动态图片
    public int updateCommPicture(CommPicture cp){
        return commPictureMapper.updateCommPicture(cp);
    }

    //根据动态id查询某个动态的所有图片
    public List<CommPicture> queryCommPictureListByRelId(int relId){
        return commPictureMapper.queryCommPictureListByRelId(relId);
    }


}
