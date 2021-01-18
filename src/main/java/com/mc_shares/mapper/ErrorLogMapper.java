package com.mc_shares.mapper;

import com.mc_shares.dto.ErrorLogDto;
import com.mc_shares.entity.ErrorLog;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ErrorLogMapper {
    ErrorLogDto mapErrorLogEntityToDto(ErrorLog errorLog);
    @InheritInverseConfiguration
    ErrorLog mapErrorLogDtoDtoToEntity(ErrorLogDto errorLogDto);
}
