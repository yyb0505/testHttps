package com.yyb.mapper;

import com.yyb.entity.CommRelease;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface CommReleaseMapper {

    //分页查询动态列表
    @Select("SELECT * FROM comm_release")
    List<CommRelease> queryCommReleaseList();

    //分页查询最新动态
    @Select("SELECT * FROM comm_release ORDER BY relCreateDate DESC")
    List<CommRelease> queryLatestCommReleaseList();

    //添加动态
    @Insert("INSERT INTO comm_release(relTitle,relDescribe,relPageView,userId,catId) VALUES(#{relTitle},#{relDescribe},#{relPageView},#{userId},#{catId})")
    int addCommRelease(CommRelease cr);

    //发表动态
    @Insert("INSERT INTO comm_release(relTitle,relDescribe,relPageView,userId,catId) VALUES(#{relTitle},#{relDescribe},#{relPageView},#{userId},#{catId})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int releaseCommRelease(CommRelease cr);

    //根据id删除图片
    @Delete("DELETE FROM comm_release WHERE id = #{id}")
    int deleteCommRelease(@Param("id") int id);

    //根据id获取动态信息
    @Select("SELECT id,relTitle,relDescribe,relPageView,userId,catId FROM comm_release WHERE id = #{id}")
    CommRelease queryCommReleaseBeanById(@Param("id") int id);

    //根据id修改动态信息
    @Update("UPDATE comm_release SET relTitle = #{relTitle},relDescribe = #{relDescribe},relPageView = #{relPageView},userId = #{userId},catId = #{catId} WHERE id = #{id}")
    int updateCommRelease(CommRelease cr);

    @Select("SELECT * FROM comm_release  WHERE DATE_FORMAT(relCreateDate, '%Y-%m-%d') = #{commDate} ORDER BY relPageView DESC LIMIT #{number};")
    List<CommRelease> communityRank(@Param("commDate") String commDate,@Param("number") int number);

    @Select("SELECT count(id),MONTH(relCreateDate) FROM comm_release where MONTH(relCreateDate) = #{month} and YEAR(relCreateDate) = #{year};")
    int queryReleaseRec(@Param("month") int month,@Param("year") int year);

    @Select("SELECT count(id),MONTH(relCreateDate) FROM comm_release left join users on comm_release.userId = users.userId where users.userName = #{userName} and MONTH(relCreateDate) = #{month} and YEAR(relCreateDate) = #{year};")
    int queryReleaseRecByName(@Param("month") int month,@Param("year") int year,@Param("userName") String userName);

}
