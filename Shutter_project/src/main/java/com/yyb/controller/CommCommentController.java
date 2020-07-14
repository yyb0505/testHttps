package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.*;
import com.yyb.service.CommCategoryService;
import com.yyb.service.CommCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommCommentController {

    @Autowired
    private CommCommentService commCommentService;

    //请求动态详细页面
    @ResponseBody
    @RequestMapping("/queryCommentList")
    public RespTableBean<CommCommentDetail> queryCommentList( int relId){
        RespTableBean<CommCommentDetail> rtb = new RespTableBean<CommCommentDetail>();
        List<CommCommentDetail> commentList = commCommentService.queryCommentList(relId);
        rtb.setCode(RespTableBean.SUCCESS);
        rtb.setMsg("查询成功！");
        rtb.setData(commentList);
        return rtb;
    }

    //插入评论
    @ResponseBody
    @RequestMapping("/insertComment")
    public RespStringBean insertComment(CommComment cc){
        RespStringBean rtb = new RespStringBean();
        int rps = commCommentService.insertComment(cc);
        if(rps > 0){
            List<CommCommentDetail> commentList = commCommentService.queryCommentList(cc.getRelId());
            queryChildCommentList(commentList);
            rtb.setCode(RespTableBean.SUCCESS);
            rtb.setMsg("评论成功！");
            rtb.setData(JSON.toJSONStringWithDateFormat(commentList,JSON.DEFFAULT_DATE_FORMAT));
        }else{
            rtb.setCode(RespBean.ERROR);
            rtb.setMsg("评论失败！");
        }
        return rtb;
    }

    private void queryChildCommentList(List<CommCommentDetail> commentList) {
        for(CommCommentDetail cc : commentList){
            List<CommCommentDetail> ccf = commCommentService.queryCommentListByComFid(cc.getId());
            if(ccf != null && ccf.size() > 0){
                cc.setCcData(ccf);
                queryChildCommentList(ccf);
            }
        }

    }

}
