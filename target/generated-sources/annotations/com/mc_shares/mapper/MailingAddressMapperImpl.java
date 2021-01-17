package com.mc_shares.mapper;

import com.mc_shares.dto.MailingAddressDto;
import com.mc_shares.entity.MailingAddress;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:48:49+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class MailingAddressMapperImpl implements MailingAddressMapper {

    @Override
    public MailingAddressDto mapMailingAddressEntityToDto(MailingAddress mailingAddress) {
        if ( mailingAddress == null ) {
            return null;
        }

        MailingAddressDto mailingAddressDto = new MailingAddressDto();

        mailingAddressDto.setMailingAddressId( mailingAddress.getMailingAddressId() );
        mailingAddressDto.setAddressLineOne( mailingAddress.getAddressLineOne() );
        mailingAddressDto.setAddressLineTwo( mailingAddress.getAddressLineTwo() );
        mailingAddressDto.setTownCity( mailingAddress.getTownCity() );
        mailingAddressDto.setCountry( mailingAddress.getCountry() );

        return mailingAddressDto;
    }

    @Override
    public MailingAddress mapMailingAddressDtoToEntity(MailingAddressDto mailingAddressDto) {
        if ( mailingAddressDto == null ) {
            return null;
        }

        MailingAddress mailingAddress = new MailingAddress();

        mailingAddress.setMailingAddressId( mailingAddressDto.getMailingAddressId() );
        mailingAddress.setAddressLineOne( mailingAddressDto.getAddressLineOne() );
        mailingAddress.setAddressLineTwo( mailingAddressDto.getAddressLineTwo() );
        mailingAddress.setTownCity( mailingAddressDto.getTownCity() );
        mailingAddress.setCountry( mailingAddressDto.getCountry() );

        return mailingAddress;
    }
}
