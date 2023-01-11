package com.demo.currancyconverter.dto;

import lombok.Data;

@Data
public class Conversion {
    public String date;
    public Info info;
    public Query query;
    public double result;
    public boolean success;
}
