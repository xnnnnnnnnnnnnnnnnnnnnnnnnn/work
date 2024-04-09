package com.example.work.service;

import com.example.work.dao.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private com.example.work.mapper.foodMapper foodMapper;
    public int save(Food food){
        if(foodMapper.select(food.getFoodid())==null){
//            新增
            return foodMapper.insert(food);
        }
        else{
            //更改
            return foodMapper.update(food);
        }
    }
}
