package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.Users;
import com.yyb.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public Users userLogin(String name,String pwd){
        Users user = usersMapper.userLogin(name, pwd);
        return user;
    }

    //增
    public int insertUsers(Users user){
        return usersMapper.insertUsers(user);
    }

    //删
    public int deleteUsers(int id){
        return usersMapper.deleteUsers(id);
    }

    //根据查询用户信息
    public Users queryUsersById(int id){
        return usersMapper.queryUsersById(id);
    }

    //改
    public int updateUsers(Users user){
        return usersMapper.updateUsers(user);
    }

    //查
    public PageInfo<Users> queryUsersList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<Users> usersList =  usersMapper.queryUsersList();
        PageInfo<Users> pageInfoUserList = new PageInfo<Users>(usersList);
        return pageInfoUserList;

    }
}
