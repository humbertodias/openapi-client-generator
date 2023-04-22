package com.company.currency.exception;

public class CurrencyRateNotFoundException extends RuntimeException {
        public CurrencyRateNotFoundException(String m) {
            super(m);
        }
    }