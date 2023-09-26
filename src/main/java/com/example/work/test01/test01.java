package com.example.work.test01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.content;
import com.example.dao.custmoer;
import com.example.dao.custmoerServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Controller
@RestController
@RequestMapping("/hello")
public class test01 extends Connect{
//微信签名，时间戳，随机数，随机字符串
    @GetMapping("/test01")
    public String test(String signature,String timestamp,String nonce,String echostr) {
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        return "successful";
    }

//    调用接口
    @GetMapping("/test02")
    public static void doGet(){
        String pathUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4913282b89fc0927&secret=163c38fceb4a48e32f69da7e5afb9322";
        try {
            HttpURLConnection conn=connGet(pathUrl);
            /**
             * 下面的代码相当于，获取调用第三方http接口后返回的结果
             *
             */
            String access_token= "";
            BufferedReader in =new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            Object inputline=in.readLine();
            String str=(String) inputline;
            JSONObject object= JSON.parseObject(str);
            System.out.println(object.get("access_token"));
            access_token=object.get("access_token").toString();
            send(access_token);
            sendPost(access_token);
//            System.out.println(sendPost(access_token));
            disConn(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    获取客服账号
    public static void sendPost(String access_token) {
        String pathUrl="https://api.weixin.qq.com/customservice/kfaccount/update?access_token="+access_token;
        PrintWriter out=null;
        BufferedReader in=null;
        HttpURLConnection conn=null;
        try {
            conn=connPost(pathUrl);
            custmoerServer cust=new custmoerServer();
            cust.setKf_account("test1@gh_72f6bf5ec9a3");
            cust.setNickname("admin");
            cust.setPassword("123");
            out=new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
//            实体类转json
            out.print(JSON.toJSONString(cust));
//            发送请求参数
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Object inputline=in.readLine();
            System.out.println(inputline);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
            disConn(conn);
        }
    }

//   发送客服消息
    public static void send(String access_token){
        String pathUrl="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
        PrintWriter out=null;
        BufferedReader in=null;
        HttpURLConnection conn=null;
        try {
            conn=connPost(pathUrl);
            custmoer custmoer=new custmoer();
//            获取用户普通oppnid
            String oppeid=openid(access_token);
//            custmoer.setTouser("u2117774dicp22");
            custmoer.setTouser(oppeid);
            content content=new content();
            content.setContent("hello");
            custmoer.setText(content);

            out=new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
//            实体类转json
            out.print(JSON.toJSONString(custmoer));
//            发送请求参数
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Object inputline=in.readLine();
            System.out.println(inputline);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String openid(String access_token){
        String pathUrl="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid=wx4913282b89fc0927&lang=zh_CN";
        HttpURLConnection conn=null;
        try {
            conn=connGet(pathUrl);
            /**
             * 下面的代码相当于，获取调用第三方http接口后返回的结果
             */
            BufferedReader in =new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            Object inputline=in.readLine();
            String str=(String) inputline;
            JSONObject object= JSON.parseObject(str);
            System.out.println(" --------"+object.get("openid"));

//            System.out.println(sendPost(access_token));
            return object.get("openid").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            disConn(conn);
            return "";
        }
    }

}

