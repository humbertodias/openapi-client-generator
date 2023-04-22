package com.company.currency.service;

import com.company.currency.client.cbr.CbrClient;
import com.company.currency.domain.CurrencyNominalRate;
import com.company.currency.domain.CurrencyRate;
import com.company.currency.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatesGettingService {
    private final CbrClient cbrClient;
    private final Parser parser;

    @Cacheable("rates")
    public List<CurrencyRate> getCurrencyRates() {
        log.info("Getting rates from CBR.");
        final String xmlCbr = cbrClient.getRatesByCbr();
        final List<CurrencyNominalRate> nominalRateList = parser.parse(xmlCbr);
        return nominalRateList.stream().map(n ->
                new CurrencyRate(
                        n.getCharCode(),
                        Double.parseDouble(n.getValue()) / Double.parseDouble(n.getNominal())))
                .collect(Collectors.toList());
    }
}
