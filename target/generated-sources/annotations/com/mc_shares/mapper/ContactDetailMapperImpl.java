package com.mc_shares.mapper;

import com.mc_shares.dto.ContactDetailDto;
import com.mc_shares.entity.ContactDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-21T09:02:25+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class ContactDetailMapperImpl implements ContactDetailMapper {

    @Override
    public ContactDetailDto mapContactDetailEntityToDto(ContactDetail contactDetail) {
        if ( contactDetail == null ) {
            return null;
        }

        ContactDetailDto contactDetailDto = new ContactDetailDto();

        contactDetailDto.setContactDetailId( contactDetail.getContactDetailId() );
        contactDetailDto.setContactName( contactDetail.getContactName() );
        contactDetailDto.setContactNumber( contactDetail.getContactNumber() );

        return contactDetailDto;
    }

    @Override
    public ContactDetail mapContactDetailDtoToEntity(ContactDetailDto contactDetailDto) {
        if ( contactDetailDto == null ) {
            return null;
        }

        ContactDetail contactDetail = new ContactDetail();

        contactDetail.setContactDetailId( contactDetailDto.getContactDetailId() );
        contactDetail.setContactName( contactDetailDto.getContactName() );
        contactDetail.setContactNumber( contactDetailDto.getContactNumber() );

        return contactDetail;
    }
}
