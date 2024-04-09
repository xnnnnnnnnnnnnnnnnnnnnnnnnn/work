package com.example.work.dao;


public class Food {

  private String foodid;
  private long number;
  private String other;
  private String supplierid;
  private String picture;


  public String getFoodid() {
    return foodid;
  }

  public void setFoodid(String foodid) {
    this.foodid = foodid;
  }


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }


  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }


  public String getSupplierid() {
    return supplierid;
  }

  public void setSupplierid(String supplierid) {
    this.supplierid = supplierid;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

}
