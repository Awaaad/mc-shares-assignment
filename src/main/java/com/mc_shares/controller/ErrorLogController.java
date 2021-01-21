package com.mc_shares.controller;

import com.mc_shares.dto.ErrorLogDto;
import com.mc_shares.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/error-log")
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @GetMapping("all")
    public ResponseEntity<List<ErrorLogDto>>getAllErrorLogs(){
        return new ResponseEntity<>(errorLogService.findAllErrorLogs(), HttpStatus.OK);
    }
}
