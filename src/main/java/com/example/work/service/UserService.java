package com.example.work.service;

import com.example.work.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private com.example.work.mapper.userMapper userMapper;

    public int save(User user) {
        if (userMapper.select(user.getUserid()) == null) {
//            新增
            System.out.println(user);

            return userMapper.insert(user);
        } else {
            //更改
            return userMapper.update(user);
        }
    }
}
