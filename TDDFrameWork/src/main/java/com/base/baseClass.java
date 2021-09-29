package com.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass 
{
	public static WebDriver driver;
	public static String vURL;
	public static Properties prop;
	
		
	public static void browserInit() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Tharun06/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
	}
	
	public static void browserClose()
	{
		driver.quit();
	}
	

}
