package com.example.work.controller.dto;

import lombok.Data;

@Data
public class OrderformDto {
    private long orderid;
    private String userid;
    private String foodid;
    private String state;
    private String other;
    private java.sql.Timestamp time;
    private String supplierid;
    private long number;
}
