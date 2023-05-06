package com.company.client.controller;

//import com.company.rates.swagger.api.RatesControllerApiClient;
//import com.company.rates.swagger.model.CurrenciesDate;
import com.company.rates.openapi.api.RatesControllerApiClient;
import com.company.rates.openapi.model.CurrenciesDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${bff.rest.api.prefix}")
public class CurrencyController {

    private final RatesControllerApiClient rateControllerApiClient;

    @GetMapping("/rate/{date}/{currencyCode}")
    public ResponseEntity<CurrenciesDate> getRateByCharCode(@PathVariable String date, @PathVariable String currencyCode) {
        return rateControllerApiClient.getRateByCharCode(date, currencyCode);
    }

    @GetMapping("/currency/{date}")
    public ResponseEntity<List<String>> getCharCodes(@PathVariable String date) {
        return rateControllerApiClient.getCurrencies(date);
    }

}
