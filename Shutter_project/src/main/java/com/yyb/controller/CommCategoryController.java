package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommCategory;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.service.CommCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommCategoryController {

    @Autowired
    private CommCategoryService commCategoryService;

    //请求动态类别界面
    @RequestMapping("/commCategoryTables")
    public String commCategoryTables(){
        return "bsmanager/tables/commCategoryTables";
    }

    //分页查询动态类别
    @ResponseBody
    @RequestMapping("/queryCommCategoryList")
    public RespTableBean<CommCategory> queryCommCategoryList(int page, int pageSize){
        PageInfo<CommCategory> commCategoryList = commCategoryService.queryCommCategoryList(page,pageSize);
        RespTableBean<CommCategory> rb = new RespTableBean<CommCategory>(RespTableBean.SUCCESS,"查询成功！",commCategoryList.getTotal(),commCategoryList.getList());
        return rb;
    }

    //请求动态类别添加界面
    @RequestMapping("/commCategoryAdd")
    public String commCategoryAdd(){
        return "bsmanager/forms/commCategoryAdd";
    }
    //动态类别添加
    @ResponseBody
    @RequestMapping("/addCommCategory")
    public RespBean addCommCategory(CommCategory ic){
        RespBean rb = new RespBean();
        int rps = commCategoryService.addCommCategory(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态类别添加成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态类别添加失败！");
        }
        return rb;
    }

    //动态类别删除
    @ResponseBody
    @RequestMapping("/deleteCommCategory")
    public RespBean deleteCommCategory(int id){
        RespBean rb = new RespBean();
        int rps = commCategoryService.deleteCommCategory(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态类别删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态类别删除失败！");
        }
        return rb;
    }

    //请求动态类别修改页面
    @RequestMapping("/commCategoryUpdate")
    public String commCategoryUpdate(Model model, int id){
        CommCategory ic = commCategoryService.queryCommCategoryBeanById(id);
        model.addAttribute("ic",JSON.toJSONString(ic));
        return "bsmanager/forms/commCategoryUpdate";
    }

    //更新动态类别页面
    @ResponseBody
    @RequestMapping("/updateCommCategory")
    public RespBean updateCommCategory(CommCategory ic){
        RespBean rb = new RespBean();
        int rps = commCategoryService.updateCommCategory(ic);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("动态类别修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("动态类别修改失败！");
        }
        return rb;
    }
}
