package com.excel.parser.excelparser.helper;

import com.excel.parser.excelparser.model.ExcelData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "ratevalue", "limits", "AI"};
    static String SHEET = "ExcelData";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<ExcelData> parseExcelFile(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<ExcelData> excelDatas = new ArrayList<ExcelData>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                ExcelData excelData = new ExcelData();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            excelData.setRateValue(((Double)currentCell.getNumericCellValue()).intValue());
                            break;
                        case 1:
                            excelData.setLimits(((Double)currentCell.getNumericCellValue()).intValue());
                            break;
                        case 2:
                            excelData.setAi(((Double)currentCell.getNumericCellValue()).intValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                excelDatas.add(excelData);
            }
            workbook.close();
            return excelDatas;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


}
