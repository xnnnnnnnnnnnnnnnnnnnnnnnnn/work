package com.example.work.controller;

import com.example.work.dao.Food;

import com.example.work.mapper.foodMapper;
import com.example.work.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/food")

public class foodController {
    @Autowired
    private foodMapper foodMapper;
    @Autowired
    private FoodService foodService;

    @GetMapping("/select/{foodid}")
    public Food select(@PathVariable String foodid){
        return foodMapper.select(foodid);
    }

    @PostMapping
    public Integer save(@RequestBody Food food){
        //新增或者更新
        return foodService.save(food);
    }

    @DeleteMapping("/delete/{foodid}")
    public Integer Delete(@PathVariable String foodid){
        return foodMapper.delete(foodid);
    }

    @PostMapping("/deletes")
    public boolean Deletes(@RequestBody List<String> ids){
        Iterator<String> it=ids.iterator();
        while (it.hasNext()){
            String s=it.next();
            if(foodMapper.delete(s)==1){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    @GetMapping("/index")
    public List<Food> index(){
        return foodMapper.findall();
    }

    @GetMapping("/page")  //分页查询接口原理
    public Map<String,Object> findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Food> data=foodMapper.selectPage(pageNum,pageSize);
        Integer total=foodMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
    @GetMapping("/page2")  //分页查询接口原理
    public Map<String,Object> findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam String supplierid){
        pageNum=(pageNum-1)*pageSize;
        Integer total=foodMapper.selectTotal(supplierid);
        List<Food> data1=foodMapper.selectPage(supplierid);
        List<Food> data=new ArrayList<>();
        int count=1;
        System.out.println("data1数据如下所示："+data1);
        for(Food i:data1){
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
