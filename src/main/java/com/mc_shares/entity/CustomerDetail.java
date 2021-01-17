package com.mc_shares.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.mc_shares.helper.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@XmlRootElement(name = "DataItem_Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDetail {
    @Id
    @XmlElement(name = "customer_id")
    @Column(name = "CUSTOMER_DETAIL_ID", nullable = false)
    private String customerDetailId;

    @XmlElement(name = "Customer_Type")
    @Column(name = "CUSTOMER_TYPE", nullable = false)
    private String customerType;

    @XmlElement(name = "Date_Of_Birth")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @Column(name = "DATE_OF_BIRTH", nullable = true)
    private Date dateOfBirth;

    @XmlElement(name = "Date_Incorp")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @Column(name = "DATE_INCORP", nullable = true)
    private Date dateIncorp;

    @XmlElement(name = "Registration_No")
    @Column(name = "REGISTRATION_NO", nullable = true)
    private String registrationNumber;

    @XmlElement(name = "Contact_Details")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_detail_id", referencedColumnName = "contact_detail_id")
    private ContactDetail contactDetail;

    @XmlElement(name = "Mailing_Address")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mailing_address_id", referencedColumnName = "mailing_address_id")
    private MailingAddress mailingAddresses;

    @XmlElement(name = "Shares_Details")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shares_detail_id", referencedColumnName = "shares_detail_id")
    private SharesDetail sharesDetails;
}
