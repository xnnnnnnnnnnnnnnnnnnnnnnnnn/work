package com.example.work.test01;


import com.alibaba.fastjson.JSON;
import com.example.dao.custmoerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connect {
    //    GET连接请求
    public static HttpURLConnection connGet(String pathUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(pathUrl);
            //打开和url之间的连接
            conn = (HttpURLConnection) url.openConnection();
            //设定请求的方法为"GET"，默认是GET
            //post与get的不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setRequestMethod("GET");
            //设置30秒连接超时
            conn.setConnectTimeout(30000);
            //设置30秒读取超时
            conn.setReadTimeout(30000);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // Post请求不能使用缓存(get可以不使用)
            conn.setUseCaches(false);
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");  //维持长链接
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            //连接，从上述url.openConnection()至此的配置必须要在connect之前完成，
            conn.connect();
            /**
             * 下面的代码相当于，获取调用第三方http接口后返回的结果
             */
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }
    //    Post连接请求
    public static HttpURLConnection connPost(String pathUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(pathUrl);
            //打开和url之间的连接
            conn = (HttpURLConnection) url.openConnection();
            //设定请求的方法为"GET"，默认是GET
            //post与get的不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setRequestMethod("POST");
            //设置30秒连接超时
            conn.setConnectTimeout(30000);
            //设置30秒读取超时
            conn.setReadTimeout(30000);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // Post请求不能使用缓存(get可以不使用)
            conn.setUseCaches(false);
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");  //维持长链接
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            //连接，从上述url.openConnection()至此的配置必须要在connect之前完成，
            conn.connect();
            /**
             * 下面的代码相当于，获取调用第三方http接口后返回的结果
             */
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    //    关闭连接
    public static void disConn(HttpURLConnection conn){
        conn.disconnect();
    }
}
