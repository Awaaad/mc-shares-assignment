package com.mc_shares.mapper;

import com.mc_shares.dto.ErrorLogDto;
import com.mc_shares.entity.ErrorLog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-18T13:49:21+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class ErrorLogMapperImpl implements ErrorLogMapper {

    @Override
    public ErrorLogDto mapErrorLogEntityToDto(ErrorLog errorLog) {
        if ( errorLog == null ) {
            return null;
        }

        ErrorLogDto errorLogDto = new ErrorLogDto();

        errorLogDto.setErrorLogId( errorLog.getErrorLogId() );
        errorLogDto.setErrorCode( errorLog.getErrorCode() );
        errorLogDto.setCustomerDetailId( errorLog.getCustomerDetailId() );
        errorLogDto.setErrorMessage( errorLog.getErrorMessage() );

        return errorLogDto;
    }

    @Override
    public ErrorLog mapErrorLogDtoDtoToEntity(ErrorLogDto errorLogDto) {
        if ( errorLogDto == null ) {
            return null;
        }

        ErrorLog errorLog = new ErrorLog();

        errorLog.setErrorLogId( errorLogDto.getErrorLogId() );
        errorLog.setErrorCode( errorLogDto.getErrorCode() );
        errorLog.setCustomerDetailId( errorLogDto.getCustomerDetailId() );
        errorLog.setErrorMessage( errorLogDto.getErrorMessage() );

        return errorLog;
    }
}
