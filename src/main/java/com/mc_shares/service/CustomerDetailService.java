package com.mc_shares.service;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.dto.CustomerDetailListDto;
import com.mc_shares.dto.CustomerDetailedInformationDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CustomerDetailService {
    List<CustomerDetailDto> findAllCustomerDetails();

    CustomerDetailDto findCustomerDetailById(String customerDetailId) throws Exception;

    CustomerDetailedInformationDto findCustomerDetailedInformation(String customerDetailId) throws Exception;

    CustomerDetailListDto searchCustomerDetail(String name, String sortOrder, String sortBy, Integer pageNumber, Integer pageSize);

    void editCustomerDetail(CustomerDetailDto customerDetailDto) throws Exception;

    void saveCustomerDetail(CustomerDetailDto customerDetailDto);

    void upload() throws IOException;

    void uploadCustomXml(File file) throws IOException;

}
