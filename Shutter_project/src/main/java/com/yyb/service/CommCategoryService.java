package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommCategory;
import com.yyb.mapper.CommCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommCategoryService {

    @Autowired
    private CommCategoryMapper commCategoryMapper;

    //分页查询动态类别
    public PageInfo<CommCategory> queryCommCategoryList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<CommCategory> commCategoryList =  commCategoryMapper.queryCommCategoryList();
        PageInfo<CommCategory> pageCommCategoryList = new PageInfo<CommCategory>(commCategoryList);
        return pageCommCategoryList;
    }

    //添加动态类别
    public int addCommCategory(CommCategory cc){
        return commCategoryMapper.addCommCategory(cc);
    }

    //删除动态类别
    public int deleteCommCategory(int id){
        return commCategoryMapper.deleteCommCategory(id);
    }

    //根据id查询动态类别信息
    public CommCategory queryCommCategoryBeanById(int id){
        return commCategoryMapper.queryCommCategoryBeanById(id);
    }

    //修改动态类别
    public int updateCommCategory(CommCategory cc){
        return commCategoryMapper.updateCommCategory(cc);
    }


}
