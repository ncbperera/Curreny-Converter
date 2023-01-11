package com.demo.currancyconverter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Query {
    public int amount;
    public String from;
    @JsonProperty("to")
    public String myto;
}
