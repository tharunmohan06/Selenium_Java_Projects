package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath= "//a[@id='menu_admin_viewAdminModule']/b")
	WebElement admin_lnk;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public AdminPage navigateToAdminPage() {
		
		admin_lnk.click();	
		return new AdminPage();
	}
}
