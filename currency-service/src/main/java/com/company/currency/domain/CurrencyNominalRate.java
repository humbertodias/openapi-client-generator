package com.company.currency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Value
@AllArgsConstructor
@Builder
public class CurrencyNominalRate implements Serializable {
    @XmlAttribute(name="ID")
    String id;
    @XmlElement(name="NumCode")
    String numCode;
    @XmlElement(name="CharCode")
    String charCode;
    @XmlElement(name="Nominal")
    String nominal;
    @XmlElement(name="Name")
    String name;
    @XmlElement(name="Value")
    String value;

}