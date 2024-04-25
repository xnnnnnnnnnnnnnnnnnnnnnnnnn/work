package com.example.work.controller;

import com.example.work.controller.dto.OrderformDto;

import com.example.work.dao.Orderform;

import com.example.work.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/page2")  //分页查询接口原理
    public Map<String,Object> findpageSupplier(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam String supplierid){
        pageNum=(pageNum-1)*pageSize;
        Integer total=orderformMapper.selectTotal(supplierid);
        List<OrderformDto> data1=orderformMapper.selectPage(supplierid);
        List<OrderformDto> data=new ArrayList<>();
        int count=1;
        System.out.println("data1数据如下所示："+data1);
        for(OrderformDto i:data1){
            System.out.println("count数据如下所示："+count+"pagenum:"+pageNum);
            if(count==(pageNum+pageSize)){
                System.out.println("-----------pageNum:"+pageNum+"pageSize:"+pageSize+"count:"+count);
                break;
            }
            if(count>=pageNum){
                data.add(i);
                System.out.println("data:-------"+i);
            }
            count=count+1;
        }
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
