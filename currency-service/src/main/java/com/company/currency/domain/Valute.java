package com.company.currency.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName("Valute")
public class Valute implements Serializable {
    @JsonProperty("ID")
    String id;
    @JsonProperty("NumCode")
    String numCode;
    @JsonProperty("CharCode")
    String charCode;
    @JsonProperty("Nominal")
    String nominal;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Value")
    String value;
}