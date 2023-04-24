package com.company.currency;

import com.company.currency.domain.cdn.Currencies;
import com.company.currency.domain.cdn.CurrenciesDate;
import com.company.currency.parser.CdnJsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurrencyEntryServiceApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void parseCdnCurrencies() throws IOException {
		var inputStream =
				Thread.currentThread().getContextClassLoader().getResourceAsStream("currencies.json");
		var mapper = new ObjectMapper();
		var map = mapper.readValue(inputStream, Currencies.class);
		assertNotNull(map);
	}


	@Test
	void parseCdnDateCurrencies() throws IOException {
		var inputStream =
				Thread.currentThread().getContextClassLoader().getResourceAsStream("currencies-eur.json");
		String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		CdnJsonParser parser = new CdnJsonParser();
		CurrenciesDate currenciesDate = parser.parse(json, "eur");
		assertNotNull(currenciesDate.getCurrency());
		assertNotNull(currenciesDate.getDate());
		assertNotNull(currenciesDate.getValues());
	}

}
