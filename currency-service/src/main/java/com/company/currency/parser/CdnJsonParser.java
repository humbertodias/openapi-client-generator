package com.company.currency.parser;

import com.company.currency.domain.cdn.CurrenciesDate;
import com.company.currency.exception.CurrencyRateParsingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CdnJsonParser {

    final ObjectMapper mapper = new ObjectMapper();

    public CurrenciesDate parse(String json, String currencyCode) {
        var rates = new CurrenciesDate();

        try {
            JsonNode rootNode = mapper.readValue(json, JsonNode.class);
            rates.setDate(rootNode.get("date").asText());
            rates.setCurrency(currencyCode);
            rates.setValues(values(rootNode, currencyCode));
        } catch (Exception ex) {
            log.error("json parsing error, json:{}", json, ex);
            throw new CurrencyRateParsingException(ex);
        }

        return rates;
    }

    private Map<String, Double> values(JsonNode rootNode, String currencyCode) {
        var map = new HashMap<String, Double>();
        var fields = rootNode.get(currencyCode).fields();
        while (fields.hasNext()) {
            var field = fields.next();
            map.put(field.getKey(), field.getValue().doubleValue());
        }
        return map;
    }
}

