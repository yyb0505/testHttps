package com.yyb.mapper;

import com.yyb.entity.ImgDownLoadRec;
import org.apache.ibatis.annotations.*;

//@Component
public interface ImgDownLoadRecMapper {

    @Select("SELECT count(id),MONTH(dowCreateDate) FROM img_downloadrecord where MONTH(dowCreateDate) = #{month} and YEAR(dowCreateDate) = #{year};")
    int queryImgDownLoadRec(@Param("month") int month,@Param("year") int year);

    @Select("SELECT count(id),MONTH(dowCreateDate) FROM img_downloadrecord imgDow left join users on imgDow.userId = users.userId where users.userName = #{userName} and MONTH(dowCreateDate) = #{month} and YEAR(dowCreateDate) = #{year};")
    int queryImgDownLoadRecByName(@Param("month") int month,@Param("year") int year,@Param("userName") String userName);

    @Insert("INSERT INTO img_downloadrecord(userId,picId) VALUES(#{userId},#{picId})")
    int insertImgDownLoadRec(ImgDownLoadRec idlr);

}
