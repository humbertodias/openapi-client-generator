package com.company.rates.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CurrencyRate
 */
@Validated


public class CurrencyRate   {
  @JsonProperty("charCode")
  private String charCode = null;

  @JsonProperty("value")
  private Double value = null;

  public CurrencyRate charCode(String charCode) {
    this.charCode = charCode;
    return this;
  }

  /**
   * Get charCode
   * @return charCode
   **/
  @ApiModelProperty(value = "")
  
    public String getCharCode() {
    return charCode;
  }

  public void setCharCode(String charCode) {
    this.charCode = charCode;
  }

  public CurrencyRate value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @ApiModelProperty(value = "")
  
    public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyRate currencyRate = (CurrencyRate) o;
    return Objects.equals(this.charCode, currencyRate.charCode) &&
        Objects.equals(this.value, currencyRate.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(charCode, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyRate {\n");
    
    sb.append("    charCode: ").append(toIndentedString(charCode)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
