package com.mc_shares.service;

import com.mc_shares.dto.ErrorLogDto;

import java.util.List;

public interface ErrorLogService {
    List<ErrorLogDto> findAllErrorLogs();
}
