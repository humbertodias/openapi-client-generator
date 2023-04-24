package com.company.currency.exception;

public class CurrencyRateParsingException extends RuntimeException {
    public CurrencyRateParsingException(Exception ex) {
        super(ex);
    }
}
