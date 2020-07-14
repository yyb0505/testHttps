package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.BsAccount;
import com.yyb.entity.Users;
import com.yyb.mapper.AccountMapper;
import com.yyb.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    //账号登录
    public BsAccount accuntLogin(String accName,String accPwd){
        return accountMapper.accuntLogin(accName,accPwd);
    };

    //增
    public int insertAccount(BsAccount ba){
        return accountMapper.insertAccount(ba);
    }

    //删
    public int deleteAccount(int id){
        return accountMapper.deleteAccount(id);
    }

    //改
    public int updateAccount(BsAccount ba){
        return accountMapper.updateAccount(ba);
    }


    //查
    public PageInfo<BsAccount> queryAccountList(int page , int pageSize){
        PageHelper.startPage(page,pageSize);
        List<BsAccount> accountList =  accountMapper.queryAccountList();
        PageInfo<BsAccount> pageInfoAccountList = new PageInfo<BsAccount>(accountList);
        return pageInfoAccountList;
    }

    //根据id查询账户信息
    public BsAccount queryAccountById(int id){
        return accountMapper.queryAccountById(id);
    }
}
