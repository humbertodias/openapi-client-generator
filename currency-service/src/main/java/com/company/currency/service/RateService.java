package com.company.currency.service;

import com.company.currency.domain.CurrencyRate;
import com.company.currency.exception.CurrencyRateNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class RateService {
    private List<String> currencies = List.of("AUD", "AZN", "GBP", "AMD", "BYN", "BGN", "BRL", "HUF", "VND", "HKD", "GEL", "DKK", "AED", "USD", "EUR", "EGP", "INR", "IDR", "KZT", "CAD", "QAR", "KGS", "CNY", "MDL", "NZD", "NOK", "PLN", "RON", "XDR", "SGD", "TJS", "THB", "TRY", "TMT", "UZS", "UAH", "CZK", "SEK", "CHF", "RSD", "ZAR", "KRW", "JPY");
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final RatesGettingService ratesGettingService;


    public CurrencyRate getRateByCharCode(String charCode) {
        final LocalDateTime time = LocalDateTime.now();
        final String date = dtf.format(time);
        log.info("Getting rate for {}.", charCode);
        return ratesGettingService.getCurrencyRates().stream()
                .filter(rate -> rate.getCharCode().equals(charCode))
                .findFirst()
                .orElseThrow(() -> new CurrencyRateNotFoundException("Currency Rate not found. Currency:" + charCode + ", date:" + date));
    }

    public LinkedList<String> getCharCodes() {
        return new LinkedList<>(currencies);
    }

}