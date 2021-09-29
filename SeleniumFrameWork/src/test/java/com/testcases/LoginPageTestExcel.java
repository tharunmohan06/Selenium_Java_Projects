package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
//import com.utility.ExcelUtility;

import junit.framework.Assert;

public class LoginPageTestExcel extends TestBase{
	
	LoginPage login;
	DashboardPage dash;
	//ExcelUtility reader;
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		//reader= new ExcelUtility(prop.getProperty("path"));
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
	public Object[][] dateFeed() 
	{
		Object[][] creds= new Object[2][2];
		creds[0][0]= "Admin";
		creds[0][1]= "admin123";
		
		creds[1][0]= "Admin";
		creds[1][1]= "admin1";
		return creds;
	}
	
	
	@AfterMethod
	public void closeSetup() 
	{
		tearDown();
	}
}
