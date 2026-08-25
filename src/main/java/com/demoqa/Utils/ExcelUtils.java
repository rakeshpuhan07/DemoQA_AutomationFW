package com.demoqa.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    /**
     * Reads Excel data and returns it as Object[][]
     *
     * @param filePath  Excel file path
     * @param sheetName Sheet name to read
     * @return Object[][]
     */
    public static Object[][] getTestData(String filePath, String sheetName) {

        Object[][] data = null;

//        try (FileInputStream fis = new FileInputStream(filePath);
        try (InputStream fis = ExcelUtils.class
                .getClassLoader()
                .getResourceAsStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            // Skip header row
            data = new Object[rowCount][colCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
