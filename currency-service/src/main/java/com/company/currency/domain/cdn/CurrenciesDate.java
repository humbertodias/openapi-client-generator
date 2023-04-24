package com.company.currency.domain.cdn;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;


@Getter
@Setter
public class CurrenciesDate implements Serializable {
    String date;

    String currency;

    Map<String,Double> values;
}
