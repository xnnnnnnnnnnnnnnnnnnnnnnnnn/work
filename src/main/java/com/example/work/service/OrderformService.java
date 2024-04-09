package com.example.work.service;

import com.example.work.dao.Orderform;
import com.example.work.mapper.orderformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderformService {
    @Autowired
    private orderformMapper orderformMapper;
    public int save(Orderform orderform){
        if(orderformMapper.select(String.valueOf(orderform.getOrderid()))==null){
//            新增
            return orderformMapper.insert(orderform);
        }
        else{
            //更改
            return orderformMapper.update(orderform);
        }
    }
}
