package com.mc_shares.helper;

import com.mc_shares.dto.ExcelDto;
import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class ExcelReportView {
    public File buildExcelDocument(List<ExcelDto> excelDtos) {
        try {
            @Cleanup Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Customer Detail Data");
            Row header = sheet.createRow(0);
            File file = File.createTempFile("customer_details", ".xls");

            header.createCell(0).setCellValue("Customer Id");
            header.createCell(1).setCellValue("Customer type");
            header.createCell(2).setCellValue("Date of birth");
            header.createCell(3).setCellValue("Date incorp");
            header.createCell(4).setCellValue("Registration number");

            int rowNum = 1;
            for (ExcelDto excelDto : excelDtos) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(excelDto.getCustomerDetailId());
                row.createCell(1).setCellValue(excelDto.getCustomerType());
                row.createCell(2).setCellValue(excelDto.getDateOfBirth());
                row.createCell(3).setCellValue(excelDto.getDateIncorp());
                row.createCell(4).setCellValue(excelDto.getRegistrationNumber());
            }

            @Cleanup var fos = new FileOutputStream(file);
            workbook.write(fos);
            return file;
        } catch (IOException ex) {
            //log
            return null;
        }
    }
}