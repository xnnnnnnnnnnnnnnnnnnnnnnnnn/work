package com.example.work.mapper;

import com.example.work.controller.dto.OrderformDto;
import com.example.work.dao.Orderform;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper

public interface orderformMapper {
    @Select("select * from orderform")
    List<Orderform> findall();

    @Select("select * from orderform where orderid=#{orderid}")
    Orderform select(String orderid);

    @Insert("INSERT INTO orderform(orderid,userid,foodid,state,other,time ) VALUES(#{orderid},#{userid},#{foodid},#{state},#{other},#{time})")
    Integer insert(Orderform orderform);

    Integer update(Orderform orderform);

    @Delete("Delete from orderform where orderid=#{orderid}")
    Integer delete(@Param("orderid") long orderid);

    @Select("select * from orderform limit #{pageNum},#{pageSize}")
    List<Orderform> selectPage0(Integer pageNum, Integer pageSize);

    @Select("select count(*) from orderform")
    Integer selectTotal0();

    @Select("select * from supplierorder where supplierid=#{supplierid}")
    List<OrderformDto> selectPage(String supplierid);

    @Select("select count(*) from supplierorder where supplierid=#{supplierid}")
    Integer selectTotal(String supplierid);

    @Select("select * from orderform where userid=#{userid} AND( state='下单成功' OR state='已发货' OR state='运输中' OR state='上门送货')")
    List<Orderform> selectPage2(String userid);

    @Select("select count(*) from orderform where userid=#{userid} AND( state='下单成功' OR state='已发货' OR state='运输中' OR state='上门送货')")
    Integer selectTotal2(String userid);

    @Select("select * from orderform where userid=#{userid} AND state!='下单成功' and state!='已发货' and state!='运输中' and state!='上门送货'")
    List<Orderform> selectPage3(String userid);

    @Select("select count(*) from orderform where userid=#{userid} AND state!='下单成功' AND state!='已发货' and state!='运输中' and state!='上门送货'")
    Integer selectTotal3(String userid);

    @Select("select * from orderform where state='待审核' or state='审核通过' or state='退款中' or state='退款成功' or state='审核失败'")
    List<Orderform> selectPage4();

    @Select("select count(*) from orderform where state='待审核' or state='审核通过' or state='退款中' or state='退款成功' or state='审核失败'")
    Integer selectTotal4();
}
