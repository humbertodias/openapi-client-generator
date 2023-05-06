package com.company.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {
        com.company.rates.swagger.api.RatesControllerApiClient.class,
        com.company.rates.openapi.api.RatesControllerApiClient.class
})
public class CurrencyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyClientApplication.class, args);
    }

}
