package com.example.work.mapper;

import com.example.work.dao.Supplier;
import com.example.work.dao.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface supplierMapper {
    @Select("select * from supplier")
    List<Supplier> findall();

    @Select("select * from supplier where supplierid=#{supplierid}")
    Supplier select(String supplierid);

    @Insert("INSERT INTO supplier(supplierid,phone,other) VALUES(#{supplierid},#{phone},#{other})")
    Integer insert(Supplier supplier);

    Integer update(Supplier supplier);

    @Delete("Delete from supplier where supplierid=#{supplierid}")
    Integer delete(@Param("supplierid") String supplierid);

    @Select("select * from supplier limit #{pageNum},#{pageSize}")
    List<Supplier> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from supplier")
    Integer selectTotal();
}
