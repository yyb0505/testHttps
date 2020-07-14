package com.yyb.service;

import com.yyb.entity.ImgDownLoadRec;
import com.yyb.mapper.ImgDownLoadRecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImgDownLoadRecService {

    @Autowired
    private ImgDownLoadRecMapper imgDownLoadRecMapper;

    //统计近期下载记录趋势图
    public Map<String, Object> queryImgDownLoadRec(int num){
       Map<String, Object> imgDownLoadRecMap = new LinkedHashMap<String,Object>();
       List<String> months = new ArrayList<String>();
       List<Integer> countList = new ArrayList<Integer>();
       for (int i = 0 ; i < num ; i++){
           Calendar calendar = Calendar.getInstance();
           calendar.add(Calendar.MONTH,-i);
           int month = calendar.get(Calendar.MONTH) + 1;
           int year = calendar.get(Calendar.YEAR);
           int count = imgDownLoadRecMapper.queryImgDownLoadRec(month,year);
           months.add(year + "-" + month);
           countList.add(count);
       }
        imgDownLoadRecMap.put("keys",months);
        imgDownLoadRecMap.put("values",countList);
        imgDownLoadRecMap.put("userName","所有用户近一年图片下载趋势图");
        return imgDownLoadRecMap;
    }

    //统计近期下载记录趋势图
    public Map<String, Object> queryImgDownLoadRecByName(int num,String userName){
        Map<String, Object> imgDownLoadRecMap = new LinkedHashMap<String,Object>();
        List<String> months = new ArrayList<String>();
        List<Integer> countList = new ArrayList<Integer>();
        for (int i = 0 ; i < num ; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,-i);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            int count = imgDownLoadRecMapper.queryImgDownLoadRecByName(month,year,userName);
            months.add(year + "-" + month);
            countList.add(count);
        }
        imgDownLoadRecMap.put("keys",months);
        imgDownLoadRecMap.put("values",countList);
        imgDownLoadRecMap.put("userName",userName + " -- 近一年图片下载趋势图");
        return imgDownLoadRecMap;
    }

    //添加下载记录
    public int insertImgDownLoadRec(ImgDownLoadRec idlr){
        return imgDownLoadRecMapper.insertImgDownLoadRec(idlr);
    }

}
