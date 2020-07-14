package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommCategory;
import com.yyb.entity.CommComment;
import com.yyb.entity.CommCommentDetail;
import com.yyb.mapper.CommCategoryMapper;
import com.yyb.mapper.CommCommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommCommentService {

    @Autowired
    private CommCommentMapper commCommentMapper;

    //根据动态查询所有评论
    public List<CommCommentDetail> queryCommentList(int relId){
        return  commCommentMapper.queryCommentList(relId);
    }

    //插入评论
    public int insertComment(CommComment cc){
        return commCommentMapper.insertComment(cc);
    }

    //根据评论父id查询评论
   public List<CommCommentDetail> queryCommentListByComFid(int comId){
        return  commCommentMapper.queryCommentListByComFid(comId);
    }



}
