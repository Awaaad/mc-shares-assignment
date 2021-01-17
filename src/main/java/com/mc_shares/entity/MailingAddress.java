package com.mc_shares.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@XmlRootElement(name = "Mailing_Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class MailingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAILING_ADDRESS_ID")
    private Long mailingAddressId;

    @XmlElement(name = "Address_Line1")
    @Column(name = "ADDRESS_LINE_One", nullable = false)
    private String addressLineOne;

    @XmlElement(name = "Address_Line2")
    @Column(name = "ADDRESS_LINE_Two", nullable = false)
    private String addressLineTwo;

    @XmlElement(name = "Town_City")
    @Column(name = "TOWN_CITY", nullable = false)
    private String townCity;

    @XmlElement(name = "Country")
    @Column(name = "COUNTRY", nullable = false)
    private String country;

}
