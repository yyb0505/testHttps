package com.yyb.mapper;

import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgPicture;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface ImgPictureMapper {

    //分页查询图片路径列表
    @Select("SELECT * FROM img_picture")
    List<ImgPicture> queryImgPictureList();

    //添加图片
    @Insert("INSERT INTO img_picture(picNumber,picDescribe,picSize,picType,picPath,groId) VALUES(#{picNumber},#{picDescribe},#{picSize},#{picType},#{picPath},#{groId})")
    int addImgPicture(ImgPicture ip);

    //根据id删除图片
    @Delete("DELETE FROM img_picture WHERE id = #{id}")
    int deleteImgPicture(@Param("id") int ip);

    //根据id获取图片信息
    @Select("SELECT id,picNumber,picDescribe,picSize,picType,picPath,groId FROM img_picture WHERE id = #{id}")
    ImgPicture queryImgPictureBeanById(@Param("id") int id);

    //根据id修改图片信息
    @Update("UPDATE img_picture SET picNumber = #{picNumber},picDescribe = #{picDescribe},picSize = #{picSize},picType = #{picType},picPath = #{picPath},groId = #{groId} WHERE id = #{id}")
    int updateImgPicture(ImgPicture ip);

    //根据组id查询所有图片
    @Select("SELECT * FROM img_picture WHERE groId = #{groId}")
    List<ImgPicture> queryImgPictureListByGroId(@Param("groId") int groId);


}
