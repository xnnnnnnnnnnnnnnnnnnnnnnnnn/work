package com.example.work.mapper;

import com.example.work.dao.Food;
import com.example.work.dao.Orderform;
import com.example.work.dao.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Mapper
public interface foodMapper {
    @Select("select * from food")
    List<Food> findall();

    @Select("select * from food where foodid=#{foodid}")
    Food select(String foodid);

    @Insert("INSERT INTO food(foodid,number,other,supplierid,picture) VALUES(#{foodid},#{number},#{other},#{supplierid},#{picture})")
    Integer insert(Food food);

    Integer update(Food food);

    @Delete("Delete from food where foodid=#{foodid}")
    Integer delete(@Param("foodid") String foodid);

    @Select("select * from food limit #{pageNum},#{pageSize}")
    List<Food> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from food")
    Integer selectTotal();

    @Select("select * from food where supplierid=#{supplierid}")
    List<Food> selectPage(String supplierid);

    @Select("select count(*) from food where supplierid=#{supplierid}")
    Integer selectTotal(String supplierid);
}
