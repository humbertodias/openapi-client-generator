package com.company.client;

import com.company.rates.swagger.api.RatesControllerApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableFeignClients(clients = RatesControllerApiClient.class)
public class CurrencyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyClientApplication.class, args);
    }

}
