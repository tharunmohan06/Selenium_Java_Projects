package com.ustglobal.JenkinsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTest 
{
	@Test
	public void getAmazonTitle() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Tharun06/Documents/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		System.out.println("Title is: "+driver.getTitle());
		driver.quit();
	}
}
