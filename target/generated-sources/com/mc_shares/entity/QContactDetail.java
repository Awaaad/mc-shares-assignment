package com.mc_shares.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContactDetail is a Querydsl query type for ContactDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContactDetail extends EntityPathBase<ContactDetail> {

    private static final long serialVersionUID = -1048441404L;

    public static final QContactDetail contactDetail = new QContactDetail("contactDetail");

    public final NumberPath<Long> contactDetailId = createNumber("contactDetailId", Long.class);

    public final StringPath contactName = createString("contactName");

    public final NumberPath<Long> contactNumber = createNumber("contactNumber", Long.class);

    public QContactDetail(String variable) {
        super(ContactDetail.class, forVariable(variable));
    }

    public QContactDetail(Path<? extends ContactDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContactDetail(PathMetadata metadata) {
        super(ContactDetail.class, metadata);
    }

}

