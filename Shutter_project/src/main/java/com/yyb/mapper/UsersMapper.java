package com.yyb.mapper;

import com.yyb.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Component
public interface UsersMapper {


    @Select("SELECT * FROM users WHERE userName = #{name}")
    Users findByName(@Param("name") String name);

    //增
    @Insert("INSERT INTO users(userName,userPwd,userSex,userPhone,userProfile,userLevel,userStatus) VALUES(#{userName},#{userPwd},#{userSex},#{userPhone},#{userProfile},#{userLevel},#{userStatus})")
    int insertUsers(Users user);

    //删
    @Insert("DELETE FROM users WHERE userId = #{id}")
    int deleteUsers(@Param("id") int id);

    //根据id查询用户信息
    @Select("SELECT userId,userName,userPwd,userSex,userPhone,userProfile,userLevel,userStatus FROM users WHERE userId = #{id}")
    Users queryUsersById(@Param("id") int id);

    //改
    @Update("UPDATE users SET userName = #{userName},userPwd = #{userPwd},userSex = #{userSex},userPhone = #{userPhone},userProfile = #{userProfile},userLevel = #{userLevel},userStatus = #{userStatus} WHERE userId = #{userId}")
    int updateUsers(Users user);

    //查
    @Select("SELECT * FROM users ORDER BY userCreateTime DESC")
    List<Users> queryUsersList();

    //用户登录
    @Select("SELECT * FROM users WHERE userName = #{name} and userPwd = #{pwd}")
    Users userLogin(@Param("name") String name,@Param("pwd") String pwd);
}
