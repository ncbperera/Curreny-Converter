package com.demo.currancyconverter.services;

import com.demo.currancyconverter.dto.Conversion;

public interface ICurrencyConverterService {
    Conversion convertCurrency(String sourceCur, String targetCur, double amount);
}
