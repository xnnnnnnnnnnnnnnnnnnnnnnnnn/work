package com.example.work.mapper;

import com.example.work.dao.User;
import org.apache.ibatis.annotations.*;


import java.util.*;

//@Mapper
public interface userMapper {
    @Select("select * from user")
    List<User> findall();

    @Select("select * from user where userid=#{userid}")
    User select(String userid);

    @Select("select * from user where userid=#{userid} and password=#{password}")
    User login(String userid,String password);

    @Insert ("INSERT INTO user(userid,password,phone,adress,other) VALUES(#{userid},#{password},#{phone},#{adress},#{other})")
    Integer insert(User user);

    Integer update(User user);


    @Delete("Delete from user where userid=#{userid}")
    Integer delete(@Param("userid") String userid);

    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from user")
    Integer selectTotal();

}
