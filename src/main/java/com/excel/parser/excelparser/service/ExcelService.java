package com.excel.parser.excelparser.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {

    void saveExcelData(MultipartFile file);
}
