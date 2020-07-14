package com.yyb.mapper;

import com.yyb.entity.CommPicture;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface CommPictureMapper {

    //分页查询动态图片路径列表
    @Select("SELECT * FROM comm_picture")
    List<CommPicture> queryCommPictureList();

    //添加动态图片
    @Insert("INSERT INTO comm_picture(picNumber,picDescribe,picSize,picType,picPath,relId) VALUES(#{picNumber},#{picDescribe},#{picSize},#{picType},#{picPath},#{relId})")
    int addCommPicture(CommPicture cp);

    //根据id删除动态图片
    @Delete("DELETE FROM comm_picture WHERE id = #{id}")
    int deleteCommPicture(@Param("id") int ip);

    //根据id获取动态图片信息
    @Select("SELECT id,picNumber,picDescribe,picSize,picType,picPath,relId FROM comm_picture WHERE id = #{id}")
    CommPicture queryCommPictureBeanById(@Param("id") int id);

    //根据id修改动态图片信息
    @Update("UPDATE comm_picture SET picNumber = #{picNumber},picDescribe = #{picDescribe},picSize = #{picSize},picType = #{picType},picPath = #{picPath},relId = #{relId} WHERE id = #{id}")
    int updateCommPicture(CommPicture cp);

    //根据动态id查询某个动态的所有图片
    @Select("SELECT * FROM comm_picture WHERE relId = #{relId}")
    List<CommPicture> queryCommPictureListByRelId(@Param("relId") int relId);



}
