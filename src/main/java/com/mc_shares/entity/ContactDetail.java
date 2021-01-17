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
@XmlRootElement(name = "Contact_Details")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_DETAIL_ID")
    private Long contactDetailId;

    @XmlElement(name = "Contact_Name")
    @Column(name = "CONTACT_NAME", nullable = false)
    private String contactName;

    @XmlElement(name = "Contact_Number")
    @Column(name = "CONTACT_NUMBER", nullable = true)
    private Long contactNumber;
}
