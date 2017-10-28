package dataDriven;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class DataReader {

    static Workbook wb = null;
    static Sheet sheet = null;
    static int numberOfRows, numberOfCol;

    public static String[] getDataFromExcelFile(String filePath, int sheetNumber) throws Exception {
        String path = System.getProperty("user.dir") + filePath;
        String[] st = fileReader(path, sheetNumber);
        return st;
    }

    public static String[][] fileReader2D(String path, int sheetNumber) throws Exception {
        String[][] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheetAt(sheetNumber);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1][numberOfCol + 1];

        for (int i = 1; i < data.length; i++) {
            Row rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                Cell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i][j] = cellData;
            }
        }
        return data;
    }
    public static String[] fileReader(String path, int sheetNumber) throws Exception {
        String[] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheetAt(sheetNumber);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1];

        for (int i = 1; i < data.length; i++) {
            Row rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                Cell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }
    public static String getCellValue(Cell cell) {
        Object value = null;

        int dataType = cell.getCellType();
        switch (dataType) {
            case Cell.CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();

    }
}

