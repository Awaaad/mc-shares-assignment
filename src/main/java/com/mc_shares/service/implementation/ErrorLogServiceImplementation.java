package com.mc_shares.service.implementation;

import com.mc_shares.dto.ErrorLogDto;
import com.mc_shares.mapper.ErrorLogMapper;
import com.mc_shares.repository.ErrorLogRepository;
import com.mc_shares.service.ErrorLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErrorLogServiceImplementation implements ErrorLogService {
    private final ErrorLogRepository errorLogRepository;
    private final ErrorLogMapper errorLogMapper;

    public ErrorLogServiceImplementation(ErrorLogRepository errorLogRepository, ErrorLogMapper errorLogMapper) {
        this.errorLogRepository = errorLogRepository;
        this.errorLogMapper = errorLogMapper;
    }

    @Override
    public List<ErrorLogDto> findAllErrorLogs() {
        return this.errorLogRepository.findAll().stream().map(errorLogMapper::mapErrorLogEntityToDto).collect(Collectors.toList());
    }
}
