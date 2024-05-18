package com.example.work.dao;

import java.sql.Timestamp;
//实例（对象）
public class Orderform {

  private long orderid;
  private String userid;
  private String foodid;
  private String state;
  private String other;
  private String time;


  public long getOrderid() {
    return orderid;
  }

  public void setOrderid(long orderid) {
    this.orderid = orderid;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getFoodid() {
    return foodid;
  }

  public void setFoodid(String foodid) {
    this.foodid = foodid;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time= time;
  }



}
