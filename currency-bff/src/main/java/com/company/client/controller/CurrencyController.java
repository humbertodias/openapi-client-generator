package com.company.client.controller;

import com.company.rates.swagger.api.RateControllerApiClient;
import com.company.rates.swagger.model.CurrencyRate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${client.rest.api.prefix}")
public class CurrencyController {
    private final RateControllerApiClient rateControllerApiClient;

    @GetMapping("/{charCode}")
    public ResponseEntity<CurrencyRate> getRateByCharCode(@PathVariable String charCode) {
        return rateControllerApiClient.getRateByCharCode(charCode);
    }

    @GetMapping("/charCodes")
    public ResponseEntity<List<String>> getCharCodes() {
        return rateControllerApiClient.getCharCodes();
    }

}
