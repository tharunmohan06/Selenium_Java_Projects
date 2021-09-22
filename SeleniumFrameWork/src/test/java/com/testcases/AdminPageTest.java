package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class AdminPageTest extends TestBase{
	AdminPage admin;
	LoginPage login;
	DashboardPage dash;
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		login= new LoginPage();
	}	
	
	
	@Test
	public void viewLoggedInUserDetails() throws Exception 
	{
		//chaining of objects in multiple pages
		dash= login.validateLogin();
		admin= dash.navigateToAdminPage();
		admin.verifyUserDetails();
	}
	
	
	@AfterMethod
	public void closeSetup() 
	{
		tearDown();
	}
}
