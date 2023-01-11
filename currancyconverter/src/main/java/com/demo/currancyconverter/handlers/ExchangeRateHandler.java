package com.demo.currancyconverter.handlers;

import com.demo.currancyconverter.dto.Conversion;
import com.demo.currancyconverter.exceptions.CurrencyNotFoundException;
import com.demo.currancyconverter.properties.DataProvierProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class ExchangeRateHandler {

    private RestTemplate restTemplate;
    private DataProvierProperties dataProvierProperties;

    public Conversion getConversion(String sourceCur, String targetCur, double amount) throws CurrencyNotFoundException {
        try {
            String url = dataProvierProperties.getUrl() + dataProvierProperties.getEndpoint();
            ResponseEntity<Conversion> response = restTemplate.exchange(url, HttpMethod.GET, setHeader(), Conversion.class,
                    targetCur, sourceCur, amount);

            return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
        }catch (Exception ex){
        	  throw new CurrencyNotFoundException("curreny.not.found");
        }
    }

    private HttpEntity<String> setHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", dataProvierProperties.getApikey());
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        return entity;
    }

}
