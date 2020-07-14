package com.yyb.mapper;

import com.yyb.entity.CommCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface CommCategoryMapper {

    //分页查询动态类别列表
    @Select("SELECT * FROM comm_category")
    List<CommCategory> queryCommCategoryList();

    //添加动态类别
    @Insert("INSERT INTO comm_category(cateName,cateDescribe) VALUES(#{cateName},#{cateDescribe})")
    int addCommCategory(CommCategory cc);

    //根据id删除图片类别
    @Delete("DELETE FROM comm_category WHERE id = #{id}")
    int deleteCommCategory(@Param("id") int id);

    //根据id获取动态类别信息
    @Select("SELECT id,cateName,cateDescribe FROM comm_category WHERE id = #{id}")
    CommCategory queryCommCategoryBeanById(@Param("id") int id);

    //根据id修改动态类别信息
    @Update("UPDATE comm_category SET cateName = #{cateName},cateDescribe = #{cateDescribe} WHERE id = #{id}")
    int updateCommCategory(CommCategory cc);

}
