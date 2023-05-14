package com.company.currency.controller;

import com.company.currency.domain.cdn.CurrenciesDate;
import com.company.currency.service.CdnGettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}", produces = MediaType.APPLICATION_JSON_VALUE)
public class RatesController {
    private final CdnGettingService cdnService;

    @GetMapping(value = "/{date}/{currencyCode}")
    public CurrenciesDate getRateByCharCode(@PathVariable String date, @PathVariable String currencyCode) {
        return cdnService.getCurrenciesRate(date, currencyCode);
    }

    @GetMapping("/{date}/currencies")
    public List<String> getCurrencies(@PathVariable String date) {
        return cdnService.getCurrencies(date).keySet().stream().collect(Collectors.toList());
    }
}