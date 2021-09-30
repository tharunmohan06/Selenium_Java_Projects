package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
//import com.utility.ExcelUtility;
import com.utility.ExcelReader;

import junit.framework.Assert;

public class LoginPageTestExcel extends TestBase{
	
	LoginPage login;
	DashboardPage dash;
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		login= new LoginPage();
	}		
	
	
	@Test(dataProvider = "dataProvider1")
	public void loginWithValidCredentials(String username, String password) throws Exception
	{
		dash= login.validateLogin(username,password);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
	}
	
	@DataProvider(name = "dataProvider1")
	public Object[][] dateFeed() throws Exception 
	{
		ExcelReader reader= new ExcelReader(prop.getProperty("excelpath"), prop.getProperty("sheetname"));
		Object[][] data= reader.getAllData();
		return data;
	}
	
	
	@AfterMethod
	public void closeSetup() 
	{
		tearDown();
	}
}
