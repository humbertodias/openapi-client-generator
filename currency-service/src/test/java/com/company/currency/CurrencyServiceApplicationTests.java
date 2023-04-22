package com.company.currency;

import com.company.currency.domain.ValCurs;
import com.company.currency.domain.Valute;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurrencyServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void parseCurrencies() throws IOException {
		InputStream inputStream =
				Thread.currentThread().getContextClassLoader().getResourceAsStream("currencies.xml");
		XmlMapper xmlMapper = new XmlMapper();
		ValCurs list = xmlMapper.readValue(inputStream, ValCurs.class);
		assertNotNull(list);
	}

	@Test
	void parseCurrency() throws IOException {
		InputStream inputStream =
				Thread.currentThread().getContextClassLoader().getResourceAsStream("currency.xml");
		XmlMapper xmlMapper = new XmlMapper();
		Valute item = xmlMapper.readValue(inputStream, Valute.class);
		assertNotNull(item);
	}

}
