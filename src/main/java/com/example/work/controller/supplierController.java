package com.example.work.controller;

import com.example.work.dao.Supplier;
import com.example.work.dao.User;
import com.example.work.mapper.supplierMapper;
import com.example.work.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supplier")
public class supplierController {

    @Autowired
    private supplierMapper supplierMapper;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/select/{supplierid}")
    public Supplier select(@PathVariable String supplierid){
        return supplierMapper.select(supplierid);
    }

    @PostMapping
    public Integer save(@RequestBody Supplier supplier){
        //新增或者更新
        return supplierService.save(supplier);
    }

    @DeleteMapping("/delete/{Supplierid}")
    public Integer Delete(@PathVariable String Supplierid){
        return supplierMapper.delete(Supplierid);
    }

    @PostMapping("/deletes")
    public boolean Deletes(@RequestBody List<String> ids){
        Iterator<String> it=ids.iterator();
        while (it.hasNext()){
            String s=it.next();
            if(supplierMapper.delete(s)==1){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    @GetMapping("/index")
    public List<Supplier> index(){
        return supplierMapper.findall();
    }

    @GetMapping("/page")  //分页查询接口原理
    public Map<String,Object> findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Supplier> data=supplierMapper.selectPage(pageNum,pageSize);
        Integer total=supplierMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
