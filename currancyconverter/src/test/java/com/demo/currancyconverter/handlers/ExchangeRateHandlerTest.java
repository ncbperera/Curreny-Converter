package com.demo.currancyconverter.handlers;

import com.demo.currancyconverter.dto.Conversion;
import com.demo.currancyconverter.exceptions.CurrencyNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ExchangeRateHandlerTest {

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private ExchangeRateHandler exchangeRateHandler;

    @Test
    void getConversionSuccess() {
        Mockito.when(exchangeRateHandler.getConversion("LKR", "USD", 1)).thenReturn(new Conversion());
        assertEquals(exchangeRateHandler.getConversion("LKR", "USD", 1), new Conversion());
    }

    @Test
    void getConversionFail() {
        Mockito.when(exchangeRateHandler.getConversion("HJKDSF", "USD", 1)).thenThrow(new CurrencyNotFoundException("Currency Not Found"));
        CurrencyNotFoundException exception = Assertions.assertThrows(CurrencyNotFoundException.class, () -> {
            exchangeRateHandler.getConversion("HJKDSF", "USD", 1);
        });
        assertEquals("Currency Not Found", exception.getMessage());
    }
}