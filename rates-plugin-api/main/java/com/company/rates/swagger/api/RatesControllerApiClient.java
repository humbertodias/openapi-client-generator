package com.company.rates.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import io.swagger.configuration.ClientConfiguration;

@FeignClient(contextId="RatesControllerApiClient", name="${openAPIDefinition.name:openAPIDefinition}", url="${openAPIDefinition.url:http://localhost:8006}", configuration = ClientConfiguration.class)
public interface RatesControllerApiClient extends RatesControllerApi {
}
