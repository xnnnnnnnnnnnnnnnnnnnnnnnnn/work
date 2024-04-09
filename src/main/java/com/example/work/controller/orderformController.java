package com.example.work.controller;

import com.example.work.dao.Orderform;
import com.example.work.dao.User;
import com.example.work.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderform")
public class orderformController {

    @Autowired
    private com.example.work.mapper.orderformMapper orderformMapper;
    @Autowired
    private OrderformService orderformService;


    @GetMapping("/select/{orderid}")
    public Orderform select(@PathVariable String orderid){
        return orderformMapper.select(orderid);
    }

    @PostMapping
    public Integer save(@RequestBody Orderform orderform){
        //新增或者更新
        return orderformService.save(orderform);
    }

    @DeleteMapping("/delete/{orderid}")
    public Integer Delete(@PathVariable long orderid){
        return orderformMapper.delete(orderid);
    }

    @PostMapping("/deletes")
    public boolean Deletes(@RequestBody List<Long> ids){
        Iterator<Long> it=ids.iterator();
        while (it.hasNext()){
            long s=it.next();
            if(orderformMapper.delete(s)==1){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    @GetMapping("/index")
    public List<Orderform> index(){
        return orderformMapper.findall();
    }

    @GetMapping("/page")  //分页查询接口原理
    public Map<String,Object> findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Orderform> data=orderformMapper.selectPage(pageNum,pageSize);
        Integer total=orderformMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
