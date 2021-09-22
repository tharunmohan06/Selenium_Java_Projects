package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
		Assert.assertEquals(prop.getProperty("logintitle"), login.validateLoginPageTitle());
	}

	
	@Test(priority = 2)
	public void loginWithValidCredentials() throws Exception
	{
		dash= login.validateLogin();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
	}
	
	
	@Test(priority = 3)
	public void loginWithInValidCredentials()
	{
		Assert.assertEquals("Invalid credentials", login.invalidLogin());
	}
	
	
	@AfterMethod
	public void closeSetup() 
	{
		tearDown();
	}
}
