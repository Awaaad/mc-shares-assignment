package com.mc_shares.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QErrorLog is a Querydsl query type for ErrorLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QErrorLog extends EntityPathBase<ErrorLog> {

    private static final long serialVersionUID = 1156877065L;

    public static final QErrorLog errorLog = new QErrorLog("errorLog");

    public final StringPath customerDetailId = createString("customerDetailId");

    public final StringPath errorCode = createString("errorCode");

    public final NumberPath<Long> errorLogId = createNumber("errorLogId", Long.class);

    public final StringPath errorMessage = createString("errorMessage");

    public QErrorLog(String variable) {
        super(ErrorLog.class, forVariable(variable));
    }

    public QErrorLog(Path<? extends ErrorLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QErrorLog(PathMetadata metadata) {
        super(ErrorLog.class, metadata);
    }

}

