package com.example.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class custmoer {
//    用户id，和发送信息
    private String touser;
    private String msgtype="text";
    private content text;


    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getText() {
        return text.getContent();
    }

    public void setText(content text) {
        this.text=text;
    }
}
