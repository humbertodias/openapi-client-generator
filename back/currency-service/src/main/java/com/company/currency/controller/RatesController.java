package com.company.currency.controller;

import com.company.currency.domain.cdn.CurrenciesDate;
import com.company.currency.service.CdnGettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}")
public class RatesController {
    private final CdnGettingService cdnService;

    @GetMapping("/{date}/{currencyCode}")
    public CurrenciesDate getRateByCharCode(@PathVariable String date, @PathVariable String currencyCode) {
        return cdnService.getCurrenciesRate(date, currencyCode);
    }

    @GetMapping("/{date}/currencies")
    public List<String> getCurrencies(@PathVariable String date) {
        return cdnService.getCurrencies(date).keySet().stream().collect(Collectors.toList());
    }
}