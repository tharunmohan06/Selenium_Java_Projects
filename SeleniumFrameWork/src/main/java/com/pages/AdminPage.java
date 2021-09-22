package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class AdminPage extends TestBase{
	
	@FindBy(id= "searchSystemUser_userName")
	WebElement usernamesearch_txt;
	
	@FindBy(id= "searchBtn")
	WebElement search_btn;
	
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void verifyUserDetails() {
		
		usernamesearch_txt.sendKeys(prop.getProperty("usersearch"));
		search_btn.click();
		
		List<WebElement> col= driver.findElements(By.xpath("//table[@id='resultTable']//th"));
		List<WebElement> row= driver.findElements(By.xpath("//table[@id='resultTable']/tbody//td"));
		
		System.out.println("--------------------------------------------");
		for (int i=1; i<col.size(); i++)
		{
			System.out.println(col.get(i).getText()+": "+row.get(i).getText());
		}
		System.out.println("--------------------------------------------");
	}
}
