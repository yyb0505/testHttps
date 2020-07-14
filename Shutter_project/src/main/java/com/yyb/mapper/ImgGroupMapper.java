package com.yyb.mapper;

import com.yyb.entity.ImgCategory;
import com.yyb.entity.ImgGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface ImgGroupMapper {

    //分页查询图片组列表
    @Select("SELECT * FROM img_group")
    List<ImgGroup> queryImgGroupList();

    //添加图片组
    @Insert("INSERT INTO img_group(groName,groDescribe,groImgPath,catId) VALUES(#{groName},#{groDescribe},#{groImgPath},#{catId})")
    int addImgGroup(ImgGroup ig);

    //根据id删除图片组
    @Delete("DELETE FROM img_group WHERE id = #{id}")
    int deleteImgGroup(@Param("id") int id);

    //根据id获取组别信息
    @Select("SELECT id,groName,groDescribe,groImgPath,catId FROM img_group WHERE id = #{id}")
    ImgGroup queryImgGroupBeanById(@Param("id") int id);

    //根据id修改类别信息
    @Update("UPDATE img_group SET groName = #{groName},groDescribe = #{groDescribe},groImgPath = #{groImgPath},catId = #{catId} WHERE id = #{id}")
    int updateImgGroup(ImgGroup ig);

    //根据类别id查询所有图片组
    @Select("SELECT * FROM img_group WHERE catId = #{catId}")
    List<ImgGroup> queryImgGroupListByCatId(@Param("catId") int catId);


}
