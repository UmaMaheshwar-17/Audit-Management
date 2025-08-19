package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    private static String excelPath = System.getProperty("user.dir") + "/testdata/Book1.xlsx";  // Set it via setExcelPath()

    public static void setExcelPath(String path) {
        excelPath = path;
    }

    public static int getRowCount(String sheetName) {
        int rowCount = 0;
        try (FileInputStream fi = new FileInputStream(excelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getCellCount(String sheetName, int rowNum) {
        int cellCount = 0;
        try (FileInputStream fi = new FileInputStream(excelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNum);
            cellCount = row.getLastCellNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellCount;
    }

    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String data = "";
        try (FileInputStream fi = new FileInputStream(excelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNum);
            XSSFCell cell = row.getCell(colNum);

            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
