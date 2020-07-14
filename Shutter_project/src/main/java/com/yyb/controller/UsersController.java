package com.yyb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.RespBean;
import com.yyb.entity.RespTableBean;
import com.yyb.entity.Users;
import com.yyb.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/uploadFile")
    public String uploadFile(){
        return "bsmanager/uploadFile";
    }

    @RequestMapping("/category")
    public String userCategory(){
        return "views/imgList";
    }

    @RequestMapping("/login")
    public String login(){
        return "views/login";
    }

    @RequestMapping("/bsIndex")
    public String bsIndex(){
        return "bsmanager/bsindex";
    }

    @RequestMapping("/userTables")
    public String dataTables(){
        return "bsmanager/tables/userTables";
    }

    //用户登录
    @ResponseBody
    @RequestMapping("/userLogin")
    public RespBean userLogin(HttpServletRequest request, String name, String pwd){
        RespBean rb = new RespBean();
        Users user = usersService.userLogin(name,pwd);
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",JSON.toJSONString(user));
        if(user != null){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("登录成功！");
            return rb;
        }else {
            rb.setCode(RespBean.ERROR);
            rb.setMsg("用户名或密码错误！");
            return rb;
        }
    }

    //添加用户界面
    @RequestMapping("/insertUserPage")
    public String insertUserPage(){
        return "bsmanager/forms/userAdd";
    }

    //增
    @ResponseBody
    @RequestMapping("/insertUsers")
    public RespBean insertUsers(Users user){
        RespBean rb = new RespBean();
        int rps = usersService.insertUsers(user);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("添加用户成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("添加用户失败！");
        }
        return rb;
    }

    //删
    @ResponseBody
    @RequestMapping("/deleteUsers")
    public RespBean deleteUsers(int id){
        RespBean rb = new RespBean();
        int rps = usersService.deleteUsers(id);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("删除用户成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("删除用户失败！");
        }
        return rb;
    }

    //修改用户界面
    @RequestMapping("/updateUserPage")
    public String updateUserPage(Model model, int id){
        Users user =  usersService.queryUsersById(id);
        model.addAttribute("user",JSON.toJSONString(user));
        return "bsmanager/forms/userUpdate";
    }

    //改
    @ResponseBody
    @RequestMapping("/updateUsers")
    public RespBean updateUsers(Users user){
        RespBean rb = new RespBean();
        int rps = usersService.updateUsers(user);
        if(rps > 0){
            rb.setCode(RespBean.SUCCESS);
            rb.setMsg("修改用户信息成功！");
        }else{
            rb.setCode(RespBean.ERROR);
            rb.setMsg("修改用户信息失败！");
        }
        return rb;
    }

    //查
    @ResponseBody
    @RequestMapping("/queryUsersList")
    public RespTableBean<Users> queryUsersList(int page, int pageSize){
        PageInfo<Users> usersList =  usersService.queryUsersList(page,pageSize);
        RespTableBean<Users> rb = new RespTableBean<Users>(0,"success",usersList.getTotal(),usersList.getList());
        return rb;
    }
}
