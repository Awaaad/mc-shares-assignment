package com.mc_shares.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "RequestDoc")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocXml {

    @XmlElementWrapper(name = "Doc_Data")
    @XmlElement(name = "DataItem_Customer")
    private List<CustomerDetail> customerDetails;
}
