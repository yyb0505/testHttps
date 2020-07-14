package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.CommRelease;
import com.yyb.mapper.CommReleaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CommReleaseService {

    @Autowired
    private CommReleaseMapper commReleaseMapper;

    //分页查询动态
    public PageInfo<CommRelease> queryCommReleaseList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<CommRelease> commReleaseList =  commReleaseMapper.queryCommReleaseList();
        PageInfo<CommRelease> pageCommReleaseList = new PageInfo<CommRelease>(commReleaseList);
        return pageCommReleaseList;
    }

    //添加动态
    public int addCommRelease(CommRelease cr){
        return commReleaseMapper.addCommRelease(cr);
    }

    //发表动态
    public int releaseCommRelease(CommRelease cr){return commReleaseMapper.releaseCommRelease(cr);};

    //删除动态
    public int deleteCommRelease(int id){
        return commReleaseMapper.deleteCommRelease(id);
    }

    //根据id查询动态信息
    public CommRelease queryCommReleaseBeanById(int id){
        return commReleaseMapper.queryCommReleaseBeanById(id);
    }

    //修改动态
    public int updateCommRelease(CommRelease cc){
        return commReleaseMapper.updateCommRelease(cc);
    }

    //动态排行榜
    public List<CommRelease> communityRank(String commDate,int number){ return commReleaseMapper.communityRank(commDate, number);};

    //分页查询最新动态
    public PageInfo<CommRelease> queryLatestCommReleaseList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<CommRelease> commReleaseList =  commReleaseMapper.queryLatestCommReleaseList();
        PageInfo<CommRelease> pageCommReleaseList = new PageInfo<CommRelease>(commReleaseList);
        return pageCommReleaseList;
    }

    //统计近期动态发表趋势图
    public Map<String, Object> queryReleaseRec(int num){
        Map<String, Object> releaseRecMap = new LinkedHashMap<String,Object>();
        List<String> months = new ArrayList<String>();
        List<Integer> countList = new ArrayList<Integer>();
        for (int i = 0 ; i < num ; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,-i);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            int count = commReleaseMapper.queryReleaseRec(month,year);
            months.add(year + "-" + month);
            countList.add(count);
        }
        releaseRecMap.put("keys",months);
        releaseRecMap.put("values",countList);
        releaseRecMap.put("userName","所有用户近一年动态发表趋势图");
        return releaseRecMap;
    }

    //统计近期动态发表趋势图
    public Map<String, Object> queryReleaseRecByName(int num,String userName){
        Map<String, Object> releaseRecMap = new LinkedHashMap<String,Object>();
        List<String> months = new ArrayList<String>();
        List<Integer> countList = new ArrayList<Integer>();
        for (int i = 0 ; i < num ; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,-i);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            int count = commReleaseMapper.queryReleaseRecByName(month,year,userName);
            months.add(year + "-" + month);
            countList.add(count);
        }
        releaseRecMap.put("keys",months);
        releaseRecMap.put("values",countList);
        releaseRecMap.put("userName",userName + " -- 近一年动态发表趋势图");
        return releaseRecMap;
    }


}
