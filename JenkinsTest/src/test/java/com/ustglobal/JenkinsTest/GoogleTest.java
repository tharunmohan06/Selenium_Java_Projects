package com.ustglobal.JenkinsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest 
{
	@Test
	public void getGoogleTitle() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Tharun06/Documents/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		System.out.println("Title is: "+driver.getTitle());
		driver.quit();
	}

}
