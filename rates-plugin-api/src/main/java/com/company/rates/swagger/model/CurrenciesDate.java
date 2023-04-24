package com.company.rates.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CurrenciesDate
 */
@Validated


public class CurrenciesDate   {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("values")
  @Valid
  private Map<String, Double> values = null;

  public CurrenciesDate date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @ApiModelProperty(value = "")
  
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
   **/
  @ApiModelProperty(value = "")
  
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
      this.values = new HashMap<String, Double>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Get values
   * @return values
   **/
  @ApiModelProperty(value = "")
  
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
