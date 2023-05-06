package com.company.rates.swagger.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;

import java.util.*;
import javax.annotation.Generated;

/**
 * CurrenciesDate
 */

@JacksonXmlRootElement(localName = "CurrenciesDate")
@XmlRootElement(name = "CurrenciesDate")
@XmlAccessorType(XmlAccessType.FIELD)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CurrenciesDate implements Serializable {

  private static final long serialVersionUID = 1L;

  @JacksonXmlProperty(localName = "date")
  private String date;

  @JacksonXmlProperty(localName = "currency")
  private String currency;

  @JacksonXmlProperty(localName = "values")
  @Valid
  private Map<String, Double> values = new HashMap<>();

  public CurrenciesDate date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  
  @Schema(name = "date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public CurrenciesDate currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  
  @Schema(name = "currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public CurrenciesDate values(Map<String, Double> values) {
    this.values = values;
    return this;
  }

  public CurrenciesDate putValuesItem(String key, Double valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Get values
   * @return values
  */
  
  @Schema(name = "values", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("values")
  public Map<String, Double> getValues() {
    return values;
  }

  public void setValues(Map<String, Double> values) {
    this.values = values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrenciesDate currenciesDate = (CurrenciesDate) o;
    return Objects.equals(this.date, currenciesDate.date) &&
        Objects.equals(this.currency, currenciesDate.currency) &&
        Objects.equals(this.values, currenciesDate.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, currency, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrenciesDate {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

