package com.yyb.mapper;

import com.yyb.entity.CommComment;
import com.yyb.entity.CommCommentDetail;
import com.yyb.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Component
public interface CommCommentMapper {

    @Select("SELECT cc.id,cc.relId,cc.comContent,cc.userId,cc.comLike,cc.comId,cc.comCreateDate,u.userName,u.userProfile FROM comm_comment cc left join users u on cc.userId = u.userId where relId = #{relId} and comId = 0 ORDER BY comCreateDate DESC")
    List<CommCommentDetail> queryCommentList(@Param("relId") int relId);

    @Insert("INSERT INTO comm_comment(relId,comContent,userId,comLike,comId) VALUES(#{relId},#{comContent},#{userId},#{comLike},#{comId})")
    int insertComment(CommComment cc);

    @Select("SELECT cc.id,cc.relId,cc.comContent,cc.userId,cc.comLike,cc.comId,cc.comCreateDate,u.userName,u.userProfile,cc2.userId 'faUserId',u2.userName 'faUserName'\n" +
            "FROM comm_comment cc left join users u on cc.userId = u.userId\n" +
            "left join comm_comment cc2 on cc.comId = cc2.id\n" +
            "left join users u2 on cc2.userId = u2.userId\n" +
            "where cc.comId = #{comId}")
    List<CommCommentDetail> queryCommentListByComFid(@Param("comId") int comId);

}
