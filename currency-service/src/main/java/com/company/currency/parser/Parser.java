package com.company.currency.parser;

import com.company.currency.domain.CurrencyNominalRate;

import java.util.List;

public interface Parser {
    List<CurrencyNominalRate> parse(String ratesAsString);
}
