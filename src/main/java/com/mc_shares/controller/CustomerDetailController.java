package com.mc_shares.controller;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.dto.CustomerDetailListDto;
import com.mc_shares.dto.CustomerDetailedInformationDto;
import com.mc_shares.service.CustomerDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/customer-detail")
public class CustomerDetailController {

    private final CustomerDetailService customerDetailService;

    public CustomerDetailController(CustomerDetailService customerDetailService) {
        this.customerDetailService = customerDetailService;
    }

    @GetMapping("all")
    public ResponseEntity<List<CustomerDetailDto>>getAllCustomerDetails(){
        return new ResponseEntity<>(customerDetailService.findAllCustomerDetails(), HttpStatus.OK);
    }

    @GetMapping("id")
    public ResponseEntity<CustomerDetailDto>getCustomerDetailById(@RequestParam String customerDetailId) throws Exception{
        return new ResponseEntity<>(customerDetailService.findCustomerDetailById(customerDetailId), HttpStatus.OK);
    }

    @GetMapping("customer-detailed-information")
    public ResponseEntity<CustomerDetailedInformationDto>getCustomerDetailedInformation(@RequestParam String customerDetailId) throws Exception{
        return new ResponseEntity<>(customerDetailService.findCustomerDetailedInformation(customerDetailId), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<CustomerDetailListDto> seachCustomerDetail(@RequestParam String name, String sortOrder, @RequestParam String sortBy, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(customerDetailService.searchCustomerDetail(name, sortOrder, sortBy, pageNumber, pageSize), HttpStatus.OK);
    }

    @PutMapping("edit-customer-detail")
    public ResponseEntity<String> editCustomerDetail(@RequestBody CustomerDetailDto customerDetailDto) throws Exception {
        customerDetailService.editCustomerDetail(customerDetailDto);
        return new ResponseEntity<String>("Customer detail edited successfully!", HttpStatus.OK);
    }

    @PostMapping("save-customer-detail")
    public ResponseEntity<String> saveCustomerDetail(@RequestBody CustomerDetailDto customerDetailDto){
        customerDetailService.saveCustomerDetail(customerDetailDto);
        return new ResponseEntity<>("Customer detail saved successfully!", HttpStatus.OK);
    }

    @PostMapping("upload-xml")
    public void uploadCustomerDetail() throws IOException {
        customerDetailService.upload();
    }

    @PostMapping("upload-xml-custom")
    public void uploadCustomerDetailCustomXml(@RequestParam("file") File file) throws IOException {
        customerDetailService.uploadCustomXml(file);
    }
}
