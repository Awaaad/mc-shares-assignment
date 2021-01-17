package com.mc_shares.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSharesDetail is a Querydsl query type for SharesDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSharesDetail extends EntityPathBase<SharesDetail> {

    private static final long serialVersionUID = -263710126L;

    public static final QSharesDetail sharesDetail = new QSharesDetail("sharesDetail");

    public final NumberPath<Long> numShares = createNumber("numShares", Long.class);

    public final NumberPath<Double> sharePrice = createNumber("sharePrice", Double.class);

    public final NumberPath<Long> sharesDetailId = createNumber("sharesDetailId", Long.class);

    public QSharesDetail(String variable) {
        super(SharesDetail.class, forVariable(variable));
    }

    public QSharesDetail(Path<? extends SharesDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSharesDetail(PathMetadata metadata) {
        super(SharesDetail.class, metadata);
    }

}

