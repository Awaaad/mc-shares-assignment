package com.mc_shares.mapper;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.entity.CustomerDetail;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:48:50+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class CustomerDetailMapperImpl implements CustomerDetailMapper {

    @Autowired
    private ContactDetailMapper contactDetailMapper;
    @Autowired
    private MailingAddressMapper mailingAddressMapper;
    @Autowired
    private SharesDetailMapper sharesDetailMapper;

    @Override
    public CustomerDetailDto mapCustomerDetailEntityToDto(CustomerDetail customerDetail) {
        if ( customerDetail == null ) {
            return null;
        }

        CustomerDetailDto customerDetailDto = new CustomerDetailDto();

        customerDetailDto.setSharesDetailDto( sharesDetailMapper.mapSharesDetailEntityToDto( customerDetail.getSharesDetails() ) );
        customerDetailDto.setContactDetailDto( contactDetailMapper.mapContactDetailEntityToDto( customerDetail.getContactDetail() ) );
        customerDetailDto.setMailingAddressDto( mailingAddressMapper.mapMailingAddressEntityToDto( customerDetail.getMailingAddresses() ) );
        customerDetailDto.setCustomerDetailId( customerDetail.getCustomerDetailId() );
        customerDetailDto.setCustomerType( customerDetail.getCustomerType() );
        customerDetailDto.setDateOfBirth( customerDetail.getDateOfBirth() );
        customerDetailDto.setDateIncorp( customerDetail.getDateIncorp() );
        customerDetailDto.setRegistrationNumber( customerDetail.getRegistrationNumber() );

        return customerDetailDto;
    }

    @Override
    public CustomerDetail mapCustomerDetailDtoToEntity(CustomerDetailDto customerDetailDto) {
        if ( customerDetailDto == null ) {
            return null;
        }

        CustomerDetail customerDetail = new CustomerDetail();

        customerDetail.setContactDetail( contactDetailMapper.mapContactDetailDtoToEntity( customerDetailDto.getContactDetailDto() ) );
        customerDetail.setSharesDetails( sharesDetailMapper.mapSharesDetailDtoToEntity( customerDetailDto.getSharesDetailDto() ) );
        customerDetail.setMailingAddresses( mailingAddressMapper.mapMailingAddressDtoToEntity( customerDetailDto.getMailingAddressDto() ) );
        customerDetail.setCustomerDetailId( customerDetailDto.getCustomerDetailId() );
        customerDetail.setCustomerType( customerDetailDto.getCustomerType() );
        customerDetail.setDateOfBirth( customerDetailDto.getDateOfBirth() );
        customerDetail.setDateIncorp( customerDetailDto.getDateIncorp() );
        customerDetail.setRegistrationNumber( customerDetailDto.getRegistrationNumber() );

        return customerDetail;
    }
}
