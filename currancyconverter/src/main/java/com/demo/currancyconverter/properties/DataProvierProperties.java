package com.demo.currancyconverter.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "currency.converter")
@Configuration
@Getter
@Setter
public class DataProvierProperties {

    private String url;
    private String apikey;
    private String endpoint;

}
