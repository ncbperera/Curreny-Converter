package com.demo.currancyconverter.services.impl;

import com.demo.currancyconverter.dto.Conversion;
import com.demo.currancyconverter.handlers.ExchangeRateHandler;
import com.demo.currancyconverter.services.ICurrencyConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyConverterServiceImpl implements ICurrencyConverterService {

    private ExchangeRateHandler exchangeRateHandler;

    @Override
    public Conversion convertCurrency(String sourceCur, String targetCur, double amount) {
        return exchangeRateHandler.getConversion(sourceCur,targetCur,amount);
    }
}
