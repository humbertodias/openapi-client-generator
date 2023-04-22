package com.company.currency.controller;

import com.company.currency.domain.CurrencyRate;
import com.company.currency.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}")
public class RateController {
    private final RateService rateService;

    @GetMapping("/{charCode}")
    public CurrencyRate getRateByCharCode(@PathVariable String charCode) {
        return rateService.getRateByCharCode(charCode);
    }

    @GetMapping("/charCodes")
    public List<String> getCharCodes() {
        return rateService.getCharCodes();
    }
}