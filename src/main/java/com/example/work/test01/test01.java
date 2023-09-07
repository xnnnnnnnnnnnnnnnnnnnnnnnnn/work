package com.example.work.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class test01 {

    @RequestMapping("/test01")
    public String test() {
        return "test01";
    }
}

