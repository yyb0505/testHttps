package com.yyb.mapper;

import com.yyb.entity.BsAccount;
import com.yyb.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Component
public interface AccountMapper {

    @Select("SELECT * FROM bs_account ORDER BY accCreateDate DESC")
    List<BsAccount> queryAccountList();

    @Insert("INSERT INTO bs_account(accName,accPassword,accAuthority) VALUES(#{accName},#{accPassword},#{accAuthority})")
    int insertAccount(BsAccount ba);

    @Update("UPDATE bs_account set accName = #{accName},accPassword = #{accPassword},accAuthority = #{accAuthority} WHERE id = #{id}")
    int updateAccount(BsAccount ba);

    @Delete("DELETE FROM bs_account WHERE id = #{id}")
    int deleteAccount(@Param("id") int id);

    @Select("SELECT id,accName,accPassword,accAuthority FROM bs_account WHERE id = #{id}")
    BsAccount queryAccountById(@Param("id") int id);

    @Select("SELECT * FROM bs_account WHERE accName = #{accName} and accPassword = #{accPwd}")
    BsAccount accuntLogin(@Param("accName") String accName,@Param("accPwd") String accPwd);
}
