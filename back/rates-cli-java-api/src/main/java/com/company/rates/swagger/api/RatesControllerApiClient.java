package com.company.rates.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${ratesController.name:ratesController}", url="${ratesController.url:http://localhost:8006}", configuration = ClientConfiguration.class)
public interface RatesControllerApiClient extends RatesControllerApi {
}
