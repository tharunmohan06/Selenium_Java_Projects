package com.ustglobal.TDDFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.base.baseClass;

public class AmazonSearch extends baseClass 
{
	public static String vURL;
	public static String vSearch;
	public static String vTitle;
	public static String xData[][];
	public static int xlRows;
	public static int xlCols;
	public static String vfilepath;

	public static void main(String[] args) throws Exception 
	{
		selectMethod();
	}

	
	public static void selectMethod() throws Exception
	{
		xlRead("C:/Users/Tharun06/Documents/JavaAutomation/TDD_FrameWork/AmazonDataFrameworks.xls");
		
		for (int i = 1; i < xlRows; i++) {

			if (xData[i][1].equalsIgnoreCase("Y")) 
			{
				browserInit();
				searchProduct(xData[i][2]);
				getTitle();
				xData[i][4] = vTitle;

				if (vTitle.contains(xData[i][3])) 
				{
					xData[i][5] = "PASS";
					takesnapshot(xData[i][0]);
					xData[i][6] = vfilepath;
				} 
				else 
				{
					xData[i][5] = "FAIL";
					takesnapshot(xData[i][0]);
					xData[i][6] = vfilepath;
				}

				tearDown();
			}
		}
		xlwrite("C:/Users/Tharun06/Documents/JavaAutomation/TDD_FrameWork/results.xls", xData);
	}
	
	
	public static void myPrint(String vMessage) {
		System.out.println(vMessage);
	}


	public static void searchProduct(String vSearch)
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(vSearch, Keys.ENTER);
	}

	public static void getTitle() 
	{
		vTitle = driver.getTitle();
		myPrint(vTitle);
	}

	public static void tearDown() 
	{
		browserClose();

	}

	@SuppressWarnings("deprecation")
	public static void xlRead(String sPath) throws Exception 
	{
		File myFile = new File(sPath);
		FileInputStream myStream = new FileInputStream(myFile);
		HSSFWorkbook myworkbook = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myworkbook.getSheetAt(0);
		xlRows = mySheet.getLastRowNum() + 1;
		xlCols = mySheet.getRow(0).getLastCellNum();
		System.out.println("Row Number is " + xlRows);
		System.out.println("Col Number is " + xlCols);
		xData = new String[xlRows][xlCols];
		for (int i = 0; i < xlRows; i++) {
			HSSFRow row = mySheet.getRow(i);
			for (short j = 0; j < xlCols; j++) {
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				xData[i][j] = value;
				System.out.print("-" + xData[i][j]);
			}
			System.out.println();
		}
	}

	public static String cellToString(HSSFCell cell) 
	{
		int type = cell.getCellType();
		Object result;
		switch (type) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("We cannot evaluate formula");
		case HSSFCell.CELL_TYPE_BLANK:
			result = "-";
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
		case HSSFCell.CELL_TYPE_ERROR:
			result = "This cell has some error";
		default:
			throw new RuntimeException("We do not support this cell type");
		}
		return result.toString();

	}

	@SuppressWarnings("deprecation")
	public static void xlwrite(String xlpath1, String[][] xData) throws Exception
	{
		System.out.println("Inside XL Write");
		File myFile1 = new File(xlpath1);
		FileOutputStream fout = new FileOutputStream(myFile1);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet mySheet1 = wb.createSheet("TestResults");
		for (int i = 0; i < xlRows; i++) {
			HSSFRow row1 = mySheet1.createRow(i);
			for (short j = 0; j < xlCols; j++) {
				HSSFCell cell1 = row1.createCell(j);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellValue(xData[i][j]);
			}
		}
		wb.write(fout);
		fout.flush();
		fout.close();
	}

	public static void takesnapshot(String vString) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				"C:/Users/Tharun06/Documents/JavaAutomation/TDD_FrameWork/screenshot" + vString + ".png");
		FileUtils.copyFile(source, DestFile);
		vfilepath = DestFile.getPath();
		System.out.println("File Path :" + vfilepath);
	}

}
