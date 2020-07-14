package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.*;
import com.yyb.service.CommCommentService;
import com.yyb.service.CommPictureService;
import com.yyb.service.CommReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CommReleaseController {

    @Autowired
    private CommReleaseService commReleaseService;

    @Autowired
    private CommPictureService commPictureService;

    @Autowired
    private CommCommentService commCommentService;

    @Value("${http_imgUrl}")
    private String http_imgUrl = null;

    //请求动态界面
    @RequestMapping("/commReleaseTables")
    public String commReleaseTables(){
        return "bsmanager/tables/commReleaseTables";
    }

    //分页查询动态
    @ResponseBody
    @RequestMapping("/queryCommReleaseList")
    public RespTableBean<CommRelease> queryCommReleaseList(int page, int pageSize){
        PageInfo<CommRelease> commReleaseList = commReleaseService.queryCommReleaseList(page,pageSize);
        RespTableBean<CommRelease> rb = new RespTableBean<CommRelease>(RespTableBean.SUCCESS,"查询成功！",commReleaseList.getTotal(),commReleaseList.getList());
        return rb;
    }

    //请求动态添加界面
    @RequestMapping("/commReleaseAdd")
    public String commReleaseAdd(){
        return "bsmanager/forms/commReleaseAdd";
    }

    //请求动态发布页面
    @RequestMapping("/releaseContentPage")
    public String releaseContent(){
        return "views/releaseContent";
    }

    //动态添加
    @ResponseBody
    @RequestMapping("/addCommRelease")
    public RespBean addCommRelease(CommRelease ic){
        RespBean rb = new RespBean();
        int rps = commReleaseService.addCommRelease(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态添加成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态添加失败！");
        }
        return rb;
    }

    //动态添加
    @ResponseBody
    @RequestMapping("/releaseContent")
    public RespBean releaseContent(CommRelease cr,String imgList){
        RespBean rb = new RespBean();
        int rps = 0;
        int id = commReleaseService.releaseCommRelease(cr);
        List<String> imgStr = (List<String>) JSON.parse(imgList);
        for(String imgPath : imgStr){
            CommPicture cp = new CommPicture();
            cp.setPicNumber(UUID.randomUUID().toString().replace("-",""));
            cp.setRelId(cr.getId());
            cp.setPicPath(imgPath);
            rps = commPictureService.addCommPicture(cp);
        }
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态发布成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态发布失败！");
        }
        return rb;
    }

    //动态删除
    @ResponseBody
    @RequestMapping("/deleteCommRelease")
    public RespBean deleteCommRelease(int id){
        RespBean rb = new RespBean();
        int rps = commReleaseService.deleteCommRelease(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态删除失败！");
        }
        return rb;
    }

    //请求动态修改页面
    @RequestMapping("/commReleaseUpdate")
    public String commReleaseUpdate(Model model, int id){
        CommRelease ic = commReleaseService.queryCommReleaseBeanById(id);
        model.addAttribute("ic",JSON.toJSONString(ic));
        return "bsmanager/forms/commReleaseUpdate";
    }

    //请求动态详细页面
    @RequestMapping("/releaseDetail")
    public String releaseDetail(Model model, int relId){
        CommRelease cr = commReleaseService.queryCommReleaseBeanById(relId);
        model.addAttribute("cr",JSON.toJSONString(cr));

        List<CommPicture> cpList = commPictureService.queryCommPictureListByRelId(relId);
        model.addAttribute("cpList",JSON.toJSONString(cpList));

        List<CommCommentDetail> commentList = commCommentService.queryCommentList(relId);
        queryChildCommentList(commentList);

        model.addAttribute("commentList",JSON.toJSONStringWithDateFormat(commentList,JSON.DEFFAULT_DATE_FORMAT));
        return "views/releaseDetail";
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

    //更新动态页面
    @ResponseBody
    @RequestMapping("/updateCommRelease")
    public RespBean updateCommRelease(CommRelease ic){
        RespBean rb = new RespBean();
        int rps = commReleaseService.updateCommRelease(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态修改失败！");
        }
        return rb;
    }

    //请求社区页面
    @RequestMapping("/communityPage")
    public String communityPage(){
        return "views/community";
    }

    //动态首页
    @ResponseBody
    @RequestMapping("/community")
    public String community(int number,int page,int pageSize){

        RespMapBean rmb = new RespMapBean();
        Map map = new HashMap<String,Object>();
        //查询动态排行榜
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String commDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        List<CommRelease> CommRank = commReleaseService.communityRank("2020-05-21",number);
        map.put("commRank",JSON.toJSONStringWithDateFormat(CommRank,"yyyy-MM-dd HH:mm:ss"));

        //分页查询最新动态
        PageInfo<CommRelease> latestCommReleaseList = commReleaseService.queryLatestCommReleaseList(page,pageSize);
        map.put("latestReleaseList",JSON.toJSONStringWithDateFormat(latestCommReleaseList.getList(),"yyyy-MM-dd HH:mm:ss"));

        rmb.setCode(RespMapBean.SUCCESS);
        rmb.setMsg("数据查询成功！");
        rmb.setData(map);
        return JSON.toJSONString(rmb);
    }

    //近期动态发表趋势图页面
    @RequestMapping("/releaseChart")
    public String imgDownLoadRecChart(){
        return "bsmanager/tables/releaseChart";
    }

    //查询近期动态发表趋势图
    @ResponseBody
    @RequestMapping("/queryReleaseRec")
    public Map<String , Object> queryReleaseRec(int num){
        Map<String , Object> releaseRecMap =  commReleaseService.queryReleaseRec(num);
        return releaseRecMap;
    }

    //查询近期动态发表趋势图
    @ResponseBody
    @RequestMapping("/queryReleaseRecByName")
    public Map<String , Object> queryReleaseRecByName(int num,String userName){
        Map<String , Object> releaseRecMap =  commReleaseService.queryReleaseRecByName(num,userName);
        return releaseRecMap;
    }
}
