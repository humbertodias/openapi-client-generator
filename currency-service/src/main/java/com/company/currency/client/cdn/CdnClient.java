package com.company.currency.client.cdn;


import com.company.currency.config.FeignConfig;
import com.company.currency.domain.cdn.Currencies;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currencyCdnClient", url = "${cdn.url}", configuration = FeignConfig.class)
public interface CdnClient {

    @Cacheable("currencies")
    @GetMapping("{date}/currencies.json")
    Currencies getCurrencies(@PathVariable String date);

    @Cacheable("currencies-rate")
    @GetMapping("{date}/currencies/{currencyCode}.json")
    String getCurrenciesRate(@PathVariable String date, @PathVariable String currencyCode);

}
