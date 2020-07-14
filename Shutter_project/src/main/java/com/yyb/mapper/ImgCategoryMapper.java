package com.yyb.mapper;

import com.yyb.entity.ImgCategory;
import com.yyb.entity.Users;
import org.apache.ibatis.annotations.*;

import javax.jws.WebService;
import java.util.List;

//@Component
public interface ImgCategoryMapper {

    //分页查询图片类别列表
    @Select("SELECT * FROM img_category")
    List<ImgCategory> queryImgCategoryList();

    //添加图片类别
    @Insert("INSERT INTO img_category(catName,catDescribe,catImgPath,catType) VALUES(#{catName},#{catDescribe},#{catImgPath},#{catType})")
    int addImgCategory(ImgCategory ic);

    //根据id删除图片类别
    @Delete("DELETE FROM img_category WHERE id = #{id}")
    int deleteImgCategory(@Param("id") int id);

    //根据id获取类别信息
    @Select("SELECT id,catName,catDescribe,catImgPath,catType FROM img_category WHERE id = #{id}")
    ImgCategory queryImgCategoryBeanById(@Param("id") int id);

    //根据id修改类别信息
    @Update("UPDATE img_category SET catName = #{catName},catDescribe = #{catDescribe},catImgPath = #{catImgPath},catType = #{catType} WHERE id = #{id}")
    int updateImgCategory(ImgCategory ic);

    //根据类型查询类别信息类别
    @Select("SELECT * FROM img_category WHERE catType = #{catType}")
    List<ImgCategory> queryImgCategoryListByType(int type);


}
