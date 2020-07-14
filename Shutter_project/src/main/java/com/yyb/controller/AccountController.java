package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.BsAccount;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.entity.Users;
import com.yyb.service.AccountService;
import com.yyb.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    //管理员登录界面
    @RequestMapping("/bslogin")
    public String bsAccountLogin(){
        return "bsmanager/bslogin";
    }

    //管理员登录验证
    //增
    @ResponseBody
    @RequestMapping("/accountLogin")
    public RespBean accountLogin(HttpServletRequest request, String accName, String accPwd){
        RespBean rb = new RespBean();
        BsAccount ba =  accountService.accuntLogin(accName,accPwd);
        if(ba != null){
            HttpSession session = request.getSession();
            session.setAttribute("accountInfo",JSON.toJSONString(ba));
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("账户登录成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("用户名或密码不正确！");
        }
        return rb;
    }

    //账户表格界面
    @RequestMapping("/accountTables")
    public String commCategoryTables(){
        return "bsmanager/tables/accountTables";
    }

    //添加页面
    @RequestMapping("/insertAccountPage")
    public String insertAccountPage(){
        return "bsmanager/forms/accountAdd";
    }


    //修改页面
    @RequestMapping("/updateAccountPage")
    public String updateAccountPage(Model model,int id){
        BsAccount ba = accountService.queryAccountById(id);
        model.addAttribute("ba",JSON.toJSONString(ba));
        return "bsmanager/forms/accountUpdate";
    }

    @RequestMapping("/bsLogin")
    public String bsLogin(){
        return "bsmanager/bslogin";
    }

    //增
    @ResponseBody
    @RequestMapping("/insertAccount")
    public RespBean insertAccount(BsAccount ba){
        RespBean rb = new RespBean();
        int rps =  accountService.insertAccount(ba);
        if(rps > 0){
           rb.setCode(RespBean.SUCCESS);
           rb.setMsg("账户创建成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("账户创建失败！");
        }
        return rb;
    }

    //删
    @ResponseBody
    @RequestMapping("/deleteAccount")
    public RespBean deleteAccount(int id){
        RespBean rb = new RespBean();
        int rps =  accountService.deleteAccount(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("账户删除成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("账户删除失败！");
        }
        return rb;
    }

    //改
    @ResponseBody
    @RequestMapping("/updateAccount")
    public RespBean updateAccount(BsAccount ba){
        RespBean rb = new RespBean();
        int rps =  accountService.updateAccount(ba);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("账户修改成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("账户修改失败！");
        }
        return rb;
    }

    //查
    @ResponseBody
    @RequestMapping("/queryAccountList")
    public RespTableBean<BsAccount> queryAccountList(int page, int pageSize){
        PageInfo<BsAccount> accountList =  accountService.queryAccountList(page,pageSize);
        RespTableBean<BsAccount> rb = new RespTableBean<BsAccount>(0,"success",accountList.getTotal(),accountList.getList());
        return rb;
    }
}
