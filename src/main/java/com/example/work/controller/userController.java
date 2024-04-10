package com.example.work.controller;

import com.example.work.controller.dto.UserDto;
import com.example.work.dao.User;
import com.example.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private com.example.work.mapper.userMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/select/{userid}")
    public User select(@PathVariable String userid){
        return userMapper.select(userid);
    }


    @PostMapping("/login")
    public boolean login(@RequestBody UserDto userDto) {
        //requestbody 将前端json转成java对象
        String userid=userDto.getUserid();
        String password=userDto.getPassword();
        System.out.println(userid+":"+password);
        if(userid==null || password==null){
            return false;
        }
        return userService.login(userDto);
    }

    @PostMapping
    public Integer save(@RequestBody User user) {
        //新增或者更新
        return userService.save(user);
    }

    @DeleteMapping("/delete/{userid}")
    public Integer Delete(@PathVariable String userid){
        return userMapper.delete(userid);
    }
    @PostMapping("/deletes")
    public boolean Deletes(@RequestBody List<String> ids){
        Iterator<String> it=ids.iterator();
        while (it.hasNext()){
            String s=it.next();
            if(userMapper.delete(s)==1){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    @GetMapping("/index")
    public List<User> index(){
        return userMapper.findall();
    }

    @GetMapping("/page")  //分页查询接口原理
    public Map<String,Object> findpage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<User> data=userMapper.selectPage(pageNum,pageSize);
        Integer total=userMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

}
