package com.mc_shares.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerDetail is a Querydsl query type for CustomerDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomerDetail extends EntityPathBase<CustomerDetail> {

    private static final long serialVersionUID = -2062758148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerDetail customerDetail = new QCustomerDetail("customerDetail");

    public final QContactDetail contactDetail;

    public final StringPath customerDetailId = createString("customerDetailId");

    public final StringPath customerType = createString("customerType");

    public final DateTimePath<java.util.Date> dateIncorp = createDateTime("dateIncorp", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final QMailingAddress mailingAddresses;

    public final StringPath registrationNumber = createString("registrationNumber");

    public final QSharesDetail sharesDetails;

    public QCustomerDetail(String variable) {
        this(CustomerDetail.class, forVariable(variable), INITS);
    }

    public QCustomerDetail(Path<? extends CustomerDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerDetail(PathMetadata metadata, PathInits inits) {
        this(CustomerDetail.class, metadata, inits);
    }

    public QCustomerDetail(Class<? extends CustomerDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contactDetail = inits.isInitialized("contactDetail") ? new QContactDetail(forProperty("contactDetail")) : null;
        this.mailingAddresses = inits.isInitialized("mailingAddresses") ? new QMailingAddress(forProperty("mailingAddresses")) : null;
        this.sharesDetails = inits.isInitialized("sharesDetails") ? new QSharesDetail(forProperty("sharesDetails")) : null;
    }

}

