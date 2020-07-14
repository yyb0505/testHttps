package com.yyb.mapper;

import com.yyb.entity.ImgSlideShow;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface ImgSlideShowMapper {

    @Select("SELECT * FROM img_slideshow ORDER BY sliCreateTime DESC")
    List<ImgSlideShow> queryImgSlideShowList();

    @Select("SELECT id,sliName,sliDescribe,sliPath,sliStatus FROM img_slideshow where id = #{id}")
    ImgSlideShow queryImgSlideShowBeanById(@Param("id") int id);

    @Update("UPDATE img_slideshow set sliName = #{sliName},sliDescribe = #{sliDescribe},sliPath = #{sliPath},sliStatus = #{sliStatus} where id = #{id}")
    int updateImgSlideShow(ImgSlideShow iss);

    @Delete("DELETE FROM img_slideshow where id = #{id}")
    int deleteImgSlideShow(@Param("id") int id);

    @Insert("INSERT INTO img_slideshow(sliName,sliDescribe,sliPath,sliStatus) VALUES(#{sliName},#{sliDescribe},#{sliPath},#{sliStatus})")
    int addImgSlideShow(ImgSlideShow iss);

    @Select("SELECT * FROM img_slideshow WHERE sliStatus = 1 ORDER BY sliCreateTime DESC")
    List<ImgSlideShow> queryPlayShow();
}
