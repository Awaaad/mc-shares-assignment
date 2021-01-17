package com.mc_shares.controller;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.dto.CustomerDetailListDto;
import com.mc_shares.dto.DownloadDto;
import com.mc_shares.dto.ExcelDto;
import com.mc_shares.entity.CustomerDetail;
import com.mc_shares.helper.ExcelReportView;
import com.mc_shares.repository.CustomerDetailRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/excel")
public class ExcelController {

    private final CustomerDetailRepository customerDetailRepository;

    public ExcelController(CustomerDetailRepository customerDetailRepository) {
        this.customerDetailRepository = customerDetailRepository;
    }

    @GetMapping("/export")
    public ResponseEntity<DownloadDto> getExcel() throws Exception {
        List<CustomerDetail> customerDetails = customerDetailRepository.findAll();
        List<ExcelDto> excelDtos = new ArrayList<>();
        customerDetails.forEach(customerDetail -> {
            excelDtos.add(new ExcelDto(customerDetail.getCustomerDetailId(), customerDetail.getCustomerDetailId(), customerDetail.getDateOfBirth(), customerDetail.getDateIncorp(), customerDetail.getRegistrationNumber()));
        });

        var file = ExcelReportView.buildExcelDocument(excelDtos);
        DownloadDto downloadDto = null;
        try {
            downloadDto = DownloadDto.builder().file(Files.readAllBytes(file.toPath())).name("customer_details.xls").build();
        } catch (IOException e) {
            //log
        }

        assert downloadDto != null;
        return ResponseEntity.ok(downloadDto);
    }
}
