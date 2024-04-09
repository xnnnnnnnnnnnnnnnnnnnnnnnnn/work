package com.example.work.service;

import com.example.work.dao.Supplier;
import com.example.work.dao.User;
import com.example.work.mapper.supplierMapper;
import com.example.work.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private com.example.work.mapper.supplierMapper supplierMapper;
    public int save(Supplier supplier){
        if(supplierMapper.select(supplier.getSupplierid())==null){
//            新增
            return supplierMapper.insert(supplier);
        }
        else{
            //更改
            return supplierMapper.update(supplier);
        }
    }
}
