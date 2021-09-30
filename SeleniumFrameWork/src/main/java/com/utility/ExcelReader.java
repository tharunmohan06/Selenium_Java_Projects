package com.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelReader(String excelpath, String sheetname) throws Exception {
		workbook = new XSSFWorkbook(excelpath);
		sheet = workbook.getSheet(sheetname);
	}

	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getColumnCount() {
		int colCount = sheet.getRow(0).getLastCellNum();
		return colCount;
	}

	public String getCellData(int rowNum, int colNum) {
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
	}

	public Object[][] getAllData() {
		int rowCount = getRowCount();
		int colCount = getColumnCount();
		Object[][] data = new Object[rowCount - 1][colCount];

		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row - 1][col] = getCellData(row, col);
			}
		}
		return data;
	}
}
