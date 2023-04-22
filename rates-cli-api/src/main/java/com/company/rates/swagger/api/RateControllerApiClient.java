package com.company.rates.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import io.swagger.configuration.ClientConfiguration;

@FeignClient(contextId="RateControllerApiClient", name="${openAPIDefinition.name:openAPIDefinition}", url="${openAPIDefinition.url:wiremock.base.path}", configuration = ClientConfiguration.class)
public interface RateControllerApiClient extends RateControllerApi {
}
