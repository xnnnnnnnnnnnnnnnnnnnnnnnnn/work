package com.example.work.service;

import com.example.work.dao.Orderform;
import com.example.work.mapper.orderformMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OrderformService {
    @Autowired
    private orderformMapper orderformMapper;
    public int save(Orderform orderform) throws ParseException {
        if(orderformMapper.select(String.valueOf(orderform.getOrderid()))==null){
//            新增
//            Date date =new Date();
//            long time=date.getTime();
//            Timestamp timenew=new Timestamp(time);
//            orderform.setTime(timenew);
            SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            orderform.setTime(formater.format(new Date()));
            System.out.println("xnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn:"+orderform.getTime());

            return orderformMapper.insert(orderform);
        }
//        else if(String.valueOf(orderform.getOrderid())==null){
//            orderform.setOrderid(System.currentTimeMillis());
//            return orderformMapper.insert(orderform);
//        }
        else{
            //更改
            return orderformMapper.update(orderform);
        }
    }
}
