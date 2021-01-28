package com.excel.parser.excelparser.service;

import com.excel.parser.excelparser.helper.ExcelHelper;
import com.excel.parser.excelparser.model.ExcelData;
import com.excel.parser.excelparser.repository.ExcelDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ExcelDataRepo excelDataRepo;

    @Override
    public void saveExcelData(MultipartFile file) {
        try {
            List<ExcelData> excelData = ExcelHelper.parseExcelFile(file.getInputStream());
            excelDataRepo.saveAll(excelData);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
