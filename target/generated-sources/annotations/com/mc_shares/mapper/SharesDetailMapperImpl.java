package com.mc_shares.mapper;

import com.mc_shares.dto.SharesDetailDto;
import com.mc_shares.entity.SharesDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:48:50+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class SharesDetailMapperImpl implements SharesDetailMapper {

    @Override
    public SharesDetailDto mapSharesDetailEntityToDto(SharesDetail sharesDetail) {
        if ( sharesDetail == null ) {
            return null;
        }

        SharesDetailDto sharesDetailDto = new SharesDetailDto();

        sharesDetailDto.setSharesDetailId( sharesDetail.getSharesDetailId() );
        sharesDetailDto.setNumShares( sharesDetail.getNumShares() );
        sharesDetailDto.setSharePrice( sharesDetail.getSharePrice() );

        return sharesDetailDto;
    }

    @Override
    public SharesDetail mapSharesDetailDtoToEntity(SharesDetailDto sharesDetailDto) {
        if ( sharesDetailDto == null ) {
            return null;
        }

        SharesDetail sharesDetail = new SharesDetail();

        sharesDetail.setSharesDetailId( sharesDetailDto.getSharesDetailId() );
        sharesDetail.setNumShares( sharesDetailDto.getNumShares() );
        sharesDetail.setSharePrice( sharesDetailDto.getSharePrice() );

        return sharesDetail;
    }
}
