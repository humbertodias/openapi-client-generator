package com.company.client.controller;

import com.company.client.helper.ResponseEntityHelper;
import com.company.rates.swagger.api.RatesControllerApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${bff.rest.api.prefix}", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CurrencyController {
    private final RatesControllerApiClient rateControllerApiClient;
    @GetMapping("/rate/{date}/{currencyCode}")
    public ResponseEntity getRateByCharCode(@PathVariable String date, @PathVariable String currencyCode) {
        var response = rateControllerApiClient.getRateByCharCode(date, currencyCode);
        return ResponseEntityHelper.forward(response);
    }

    @GetMapping("/currency/{date}")
    public ResponseEntity getCharCodes(@PathVariable String date) {
        var response = rateControllerApiClient.getCurrencies(date);
        return ResponseEntityHelper.forward(response);
    }

}
