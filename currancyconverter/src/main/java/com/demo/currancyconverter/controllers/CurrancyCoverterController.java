package com.demo.currancyconverter.controllers;

import com.demo.currancyconverter.constants.HttpConstants;
import com.demo.currancyconverter.dto.Conversion;
import com.demo.currancyconverter.services.ICurrencyConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.currancyconverter.constants.UtilConstants.API_BASE_CURRENCY;

@RestController
@AllArgsConstructor
@RequestMapping(value = API_BASE_CURRENCY, produces = HttpConstants.APPLICATION_JSON)
public class CurrancyCoverterController {

    private ICurrencyConverterService iCurrencyConverterService;

    @PostMapping(value = "/source/{sourceCurrency}/target/{targetCurrency}/amount/{amount}")
    public ResponseEntity<Conversion> convertCurrency(@PathVariable String sourceCurrency,
                                                      @PathVariable String targetCurrency,
                                                      @PathVariable double amount) {
        return new ResponseEntity<>(
                iCurrencyConverterService.convertCurrency(sourceCurrency, targetCurrency, amount), HttpStatus.OK);
    }
}
