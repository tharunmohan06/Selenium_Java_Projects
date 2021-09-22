package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id= "txtUsername")
	WebElement username_txt;
	
	@FindBy(id= "txtPassword")
	WebElement password_txt;
	
	@FindBy(id= "btnLogin")
	WebElement login_btn;
	
	@FindBy(xpath= "//span[@id='spanMessage']")
	WebElement error_msg;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		log.info("Validating the login page title");
		return driver.getTitle();
	}
	
	public DashboardPage validateLogin() {
		log.info("Logging into the application with valid credentials");
		username_txt.sendKeys(prop.getProperty("username"));
		password_txt.sendKeys(prop.getProperty("password"));
		login_btn.click();
		
		return new DashboardPage();
	}
	
	public String invalidLogin() {
		log.info("Logging into the application with invalid credentials");
		username_txt.sendKeys(prop.getProperty("invalidusername"));
		password_txt.sendKeys(prop.getProperty("invalidpassword"));
		login_btn.click();
		
		return error_msg.getText();
	}
	
}
