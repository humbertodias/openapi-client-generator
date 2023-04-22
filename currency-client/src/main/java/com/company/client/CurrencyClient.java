package com.company.client;

import com.company.rates.swagger.api.RateControllerApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableFeignClients(clients = RateControllerApiClient.class)
public class CurrencyClient {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CurrencyClient.class, args);
        var client = context.getBean(RateControllerApiClient.class);
        if (args.length > 0) {
            var rateCode = args[0];
            log.info("Rate {}", client.getRateByCharCode(rateCode));
            System.exit(0);
        } else {
            var charCodes = client.getCharCodes().getBody();
            log.warn("Usage> java -jar currency-client.jar {}", charCodes);
            System.exit(-1);
        }
    }

}
