package com.company.currency.service;

import com.company.currency.client.cdn.CdnClient;
import com.company.currency.domain.cdn.Currencies;
import com.company.currency.domain.cdn.CurrenciesDate;
import com.company.currency.parser.CdnJsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CdnGettingService {
    private final CdnClient client;
    private final CdnJsonParser parser;

    public Currencies getCurrencies(String date) {
        log.info("Getting currencies from CDN date {}", date);
        return client.getCurrencies(date);
    }

    public CurrenciesDate getCurrenciesRate(String date, String currencyCode) {
        log.info("Getting rates from CDN date {} currencyCode {}", date, currencyCode);
        var json = client.getCurrenciesRate(date, currencyCode);
        return parser.parse(json, currencyCode);
    }

}
