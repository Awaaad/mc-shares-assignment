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
@XmlRootElement(name = "Shares_Details")
@XmlAccessorType(XmlAccessType.FIELD)
public class SharesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARES_DETAIL_ID")
    private Long sharesDetailId;

    @XmlElement(name = "Num_Shares")
    @Column(name = "NUM_SHARES", nullable = false)
    private Long numShares;

    @XmlElement(name = "Share_Price")
    @Column(name = "SHARE_PRICE", nullable = false)
    private Double sharePrice;
}
