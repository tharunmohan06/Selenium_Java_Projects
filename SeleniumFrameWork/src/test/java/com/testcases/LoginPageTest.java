package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	DashboardPage dash;
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		login= new LoginPage();
	}		
	
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest() 
	{
		ExtentTest test= extent.createTest("OrangeHRM login page Title Test");
		Assert.assertEquals(prop.getProperty("logintitle"), login.validateLoginPageTitle());
		test.log(Status.PASS, "TC Passed");
	}

	
	@Test(priority = 2)
	public void loginWithValidCredentials() throws Exception
	{
		ExtentTest test= extent.createTest("OrangeHRM login Test");
		dash= login.validateLogin();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
		test.log(Status.PASS, "TC Passed");
	}
	
	
	@Test(priority = 3)
	public void loginWithInValidCredentials()
	{
		ExtentTest test= extent.createTest("OrangeHRM login Test with invalid creds");
		Assert.assertEquals("Invalid credentials", login.invalidLogin());
		test.log(Status.PASS, "TC Passed");
	}
	
	
	@AfterMethod
	public void closeSetup() 
	{
		tearDown();
		extent.flush();
	}
}
