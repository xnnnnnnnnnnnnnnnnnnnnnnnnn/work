package com.example.work.mapper;

import com.example.work.dao.Orderform;
import com.example.work.dao.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper

public interface orderformMapper {
    @Select("select * from orderform")
    List<Orderform> findall();

    @Select("select * from orderform where orderid=#{orderid}")
    Orderform select(String orderid);

    @Insert("INSERT INTO orderform(orderid,userid,foodid,state,other) VALUES(#{orderid},#{userid},#{foodid},#{state},#{other})")
    Integer insert(Orderform orderform);

    Integer update(Orderform orderform);

    @Delete("Delete from orderform where orderid=#{orderid}")
    Integer delete(@Param("orderid") long orderid);

    @Select("select * from orderform limit #{pageNum},#{pageSize}")
    List<Orderform> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from orderform")
    Integer selectTotal();
}
