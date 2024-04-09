package com.example.work.dao;


public class Orderform {

  private long orderid;
  private String userid;
  private String foodid;
  private String state;
  private String other;
  private java.sql.Timestamp time;


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


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

}
