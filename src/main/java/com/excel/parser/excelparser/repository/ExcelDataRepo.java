package com.excel.parser.excelparser.repository;

import com.excel.parser.excelparser.model.ExcelData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelDataRepo extends JpaRepository<ExcelData, Integer> {
}
