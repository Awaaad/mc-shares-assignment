package com.mc_shares.service.implementation;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.dto.CustomerDetailListDto;
import com.mc_shares.dto.CustomerDetailedInformationDto;
import com.mc_shares.entity.CustomerDetail;
import com.mc_shares.entity.DocXml;
import com.mc_shares.entity.ErrorLog;
import com.mc_shares.entity.QCustomerDetail;
import com.mc_shares.mapper.CustomerDetailMapper;
import com.mc_shares.repository.ContactDetailRepository;
import com.mc_shares.repository.CustomerDetailRepository;
import com.mc_shares.repository.ErrorLogRepository;
import com.mc_shares.service.CustomerDetailService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerDetailServiceImplementation implements CustomerDetailService {

    private final CustomerDetailRepository customerDetailRepository;
    private final CustomerDetailMapper customerDetailMapper;
    private final ContactDetailRepository contactDetailRepository;
    private final ErrorLogRepository errorLogRepository;

    public CustomerDetailServiceImplementation(CustomerDetailRepository customerDetailRepository, CustomerDetailMapper customerDetailMapper, ContactDetailRepository contactDetailRepository, ErrorLogRepository errorLogRepository) {
        this.customerDetailRepository = customerDetailRepository;
        this.customerDetailMapper = customerDetailMapper;
        this.contactDetailRepository = contactDetailRepository;
        this.errorLogRepository = errorLogRepository;
    }

    @Override
    public List<CustomerDetailDto> findAllCustomerDetails() {
        return customerDetailRepository.findAll().stream().map(customerDetailMapper::mapCustomerDetailEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDetailDto findCustomerDetailById(String customerDetailId) throws Exception {
        var customerDetailEntity = customerDetailRepository.findById(customerDetailId).orElseThrow(null);
        if (Objects.nonNull(customerDetailEntity)) {
            return customerDetailMapper.mapCustomerDetailEntityToDto(customerDetailEntity);
        } else {
            throw new Exception("customer.detail.not.found");
        }
    }

    @Override
    public CustomerDetailedInformationDto findCustomerDetailedInformation(String customerDetailId) throws Exception {
        var customerDetailEntity = customerDetailRepository.findById(customerDetailId).orElse(null);

        CustomerDetailedInformationDto customerDetailedInformationDto = new CustomerDetailedInformationDto();
        if (Objects.nonNull(customerDetailEntity)) {

            customerDetailedInformationDto.setId(customerDetailEntity.getCustomerDetailId());
            customerDetailedInformationDto.setCustomerName(customerDetailEntity.getContactDetail().getContactName());
            customerDetailedInformationDto.setDateOfBirth(customerDetailEntity.getDateOfBirth());
            customerDetailedInformationDto.setCustomerType(customerDetailEntity.getCustomerType());
            customerDetailedInformationDto.setNumberOfShares(customerDetailEntity.getSharesDetails().getNumShares());
            customerDetailedInformationDto.setSharePricePerUnit(customerDetailEntity.getSharesDetails().getSharePrice());
            customerDetailedInformationDto.setBalance(customerDetailEntity.getSharesDetails().getSharePrice() * customerDetailEntity.getSharesDetails().getNumShares());
        } else {
            throw new Exception("customer.detail.not.found");
        }

        return customerDetailedInformationDto;
    }

    @Override
    public CustomerDetailListDto searchCustomerDetail(String name, String sortOrder, String sortBy, Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by("ASC".equals(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        BooleanBuilder predicate = buildProductPredicate(name);
        Page<CustomerDetail> customerDetails = customerDetailRepository.findAll(predicate,pageRequest);
        List<CustomerDetailDto> customerDetailDtos = customerDetails.stream().map(customerDetailMapper::mapCustomerDetailEntityToDto).collect(Collectors.toList());
        var customerDetailListDto = new CustomerDetailListDto();
        customerDetailListDto.setCustomerDetailsDto(customerDetailDtos);
        customerDetailListDto.setTotalElements(customerDetails.getNumberOfElements());
        customerDetailListDto.setTotalPages(customerDetails.getTotalPages());
        return customerDetailListDto;
    }

    private BooleanBuilder buildProductPredicate(String name) {
        var qCustomerDetail = QCustomerDetail.customerDetail;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(!name.equals("")) {
            booleanBuilder.and(qCustomerDetail.contactDetail.contactName.toLowerCase().contains(name.toLowerCase()));
        }
        return booleanBuilder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editCustomerDetail(CustomerDetailDto customerDetailDto) throws Exception {
        var optionalCustomerDetail = customerDetailRepository.findById(customerDetailDto.getCustomerDetailId());
        var customerDetail = optionalCustomerDetail.orElse(null);

        if (Objects.nonNull(customerDetail)) {
            customerDetail.setCustomerType(customerDetailDto.getCustomerType());

            if (!customerDetailDto.getCustomerType().equalsIgnoreCase("Corporate")) {
                var shareDetail = customerDetail.getSharesDetails();
                shareDetail.setNumShares(customerDetailDto.getSharesDetailDto().getNumShares());
                customerDetail.setSharesDetails(shareDetail);
            }
            customerDetail.getSharesDetails().setSharePrice(customerDetailDto.getSharesDetailDto().getSharePrice());

            customerDetail.setDateOfBirth(customerDetailDto.getDateOfBirth());
            customerDetail.setDateIncorp(customerDetailDto.getDateIncorp());
            customerDetail.setRegistrationNumber(customerDetailDto.getRegistrationNumber());

            var mailingAddress = customerDetail.getMailingAddresses();
            mailingAddress.setAddressLineOne(customerDetailDto.getMailingAddressDto().getAddressLineOne());
            mailingAddress.setAddressLineTwo(customerDetailDto.getMailingAddressDto().getAddressLineTwo());
            mailingAddress.setTownCity(customerDetailDto.getMailingAddressDto().getTownCity());
            mailingAddress.setCountry(customerDetailDto.getMailingAddressDto().getCountry());

            var contactDetail = customerDetail.getContactDetail();
            contactDetail.setContactName(customerDetailDto.getContactDetailDto().getContactName());
            contactDetail.setContactNumber(customerDetailDto.getContactDetailDto().getContactNumber());

            customerDetailRepository.save(customerDetail);
        } else {
            throw new Exception("customer.detail.not.found");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCustomerDetail(CustomerDetailDto customerDetailDto) {
        var customerDetailEntity = customerDetailMapper.mapCustomerDetailDtoToEntity(customerDetailDto);
        var savedContactDetail = contactDetailRepository.save(customerDetailEntity.getContactDetail());
        customerDetailEntity.setContactDetail(savedContactDetail);
        var savedCustomerDetail = customerDetailRepository.save(customerDetailEntity);
    }

    @Override
    @Transactional
    public void upload() throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(DocXml.class);
            Unmarshaller un = context.createUnmarshaller();
            DocXml docXml = (DocXml) un.unmarshal(new File("McShares_2018.xml"));
            List<CustomerDetail> customerDetails = docXml.getCustomerDetails();
            for (CustomerDetail customerDetail: customerDetails) {
                System.out.println("DOB: " + customerDetail.getDateOfBirth());
                System.out.println("Date Incorp:" + customerDetail.getDateIncorp());
            }
            saveAllCustomerDetail(customerDetails);
        } catch (JAXBException e) {
            ErrorLog errorLog = new ErrorLog();
            errorLog.setErrorCode(e.getErrorCode());
            errorLog.setErrorMessage(e.getCause().getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void uploadCustomXml(File file) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(DocXml.class);
            Unmarshaller un = context.createUnmarshaller();
            DocXml docXml = (DocXml) un.unmarshal(file);
            List<CustomerDetail> customerDetails = docXml.getCustomerDetails();
            for (CustomerDetail customerDetail: customerDetails) {
                System.out.println("DOB: " + customerDetail.getDateOfBirth());
                System.out.println("Date Incorp:" + customerDetail.getDateIncorp());
            }
            saveAllCustomerDetail(customerDetails);
        } catch (JAXBException e) {
            ErrorLog errorLog = new ErrorLog();
            errorLog.setErrorCode(e.getErrorCode());
            errorLog.setErrorMessage(e.getCause().getMessage());
            e.printStackTrace();
        }
    }

    private void saveAllCustomerDetail(List<CustomerDetail> customerDetails) {
        List<CustomerDetail> newListOfCustomerDetail = new ArrayList<CustomerDetail>();
        customerDetails.forEach(customerDetail -> {
            if (customerDetail.getCustomerType().equals("Individual") && Objects.nonNull(customerDetail.getDateOfBirth())) {
                if (calculateAge(convertToLocalDateViaInstant(customerDetail.getDateOfBirth()), LocalDate.now()) >= 18) {
                    if (Objects.nonNull(customerDetail.getSharesDetails().getNumShares()) && customerDetail.getSharesDetails().getNumShares() > 0) {
                        if (Objects.nonNull(customerDetail.getSharesDetails().getSharePrice()) && customerDetail.getSharesDetails().getSharePrice() > 0D) {
                            if (BigDecimal.valueOf(customerDetail.getSharesDetails().getSharePrice()).scale() > 2) {
                                setErrorLog(customerDetail.getCustomerDetailId(), "Share price is has more than 2 decimal places");
                            } else {
                                newListOfCustomerDetail.add(customerDetail);
                            }
                        } else {
                            setErrorLog(customerDetail.getCustomerDetailId(), "Share price is less than 0");
                        }
                    } else {
                        setErrorLog(customerDetail.getCustomerDetailId(), "Number of shares is less than 0");
                    }

                } else {
                    setErrorLog(customerDetail.getCustomerDetailId(), "Customer Type is " + customerDetail.getCustomerType() + "but age is less than 18");
                }
            } else {
                setErrorLog(customerDetail.getCustomerDetailId(), "Date of Birth has not been provided");
            }
        });
        customerDetailRepository.saveAll(newListOfCustomerDetail);

    }

    private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private void setErrorLog(String customerDetailId, String errorMessage) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setCustomerDetailId(customerDetailId);
        errorLog.setErrorMessage(errorMessage);
        errorLogRepository.save(errorLog);
    }
}
