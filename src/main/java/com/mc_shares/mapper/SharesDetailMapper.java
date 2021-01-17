package com.mc_shares.mapper;

import com.mc_shares.dto.SharesDetailDto;
import com.mc_shares.entity.SharesDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SharesDetailMapper {
    SharesDetailDto mapSharesDetailEntityToDto(SharesDetail sharesDetail);
    @InheritInverseConfiguration
    SharesDetail mapSharesDetailDtoToEntity(SharesDetailDto sharesDetailDto);
}
