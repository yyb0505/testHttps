package com.yyb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyb.entity.ImgSlideShow;
import com.yyb.entity.Users;
import com.yyb.mapper.ImgSlideShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgSlideShowService {

    @Autowired
    private ImgSlideShowMapper imgSlideShowMapper;

    //分页查询轮播图数据
    public PageInfo<ImgSlideShow> queryImgSlideShowList(int page , int pageSize){

        PageHelper.startPage(page,pageSize);
        List<ImgSlideShow> imgSlideShowList =  imgSlideShowMapper.queryImgSlideShowList();
        PageInfo<ImgSlideShow> pageInfoImgShowList = new PageInfo<ImgSlideShow>(imgSlideShowList);
        return pageInfoImgShowList;

    }

    //查询在用的轮播图
    public List<ImgSlideShow> queryPlayShowList(){
        return imgSlideShowMapper.queryPlayShow();
    }

    //根据id查询轮播图对象
    public ImgSlideShow queryImgSlideShowBeanById(int id){
       return imgSlideShowMapper.queryImgSlideShowBeanById(id);
    }

    //修改轮播图
    public int updateImgSlideShow(ImgSlideShow iss){
        return imgSlideShowMapper.updateImgSlideShow(iss);
    }

    //删除轮播图
    public int deleteImgSlideShow(int id){
        return imgSlideShowMapper.deleteImgSlideShow(id);
    }

    //添加轮播图
    public int addImgSlideShow(ImgSlideShow iss){
        return imgSlideShowMapper.addImgSlideShow(iss);
    }


}
