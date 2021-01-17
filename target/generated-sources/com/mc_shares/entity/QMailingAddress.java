package com.mc_shares.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMailingAddress is a Querydsl query type for MailingAddress
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMailingAddress extends EntityPathBase<MailingAddress> {

    private static final long serialVersionUID = -2110976042L;

    public static final QMailingAddress mailingAddress = new QMailingAddress("mailingAddress");

    public final StringPath addressLineOne = createString("addressLineOne");

    public final StringPath addressLineTwo = createString("addressLineTwo");

    public final StringPath country = createString("country");

    public final NumberPath<Long> mailingAddressId = createNumber("mailingAddressId", Long.class);

    public final StringPath townCity = createString("townCity");

    public QMailingAddress(String variable) {
        super(MailingAddress.class, forVariable(variable));
    }

    public QMailingAddress(Path<? extends MailingAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMailingAddress(PathMetadata metadata) {
        super(MailingAddress.class, metadata);
    }

}

