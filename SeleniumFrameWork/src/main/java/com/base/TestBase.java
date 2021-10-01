package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static String reportPath;
	
	public TestBase() {
		prop= new Properties();
		FileInputStream input;
		
		try {
			input= new FileInputStream("./src/main/java/com/config/config.properties");
			prop.load(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void initialization() {
		
		log= Logger.getLogger(TestBase.class);
		String browser= prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			log.info("Selected the "+browser+" browser");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			log.info("Selected the "+browser+" browser");
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			log.warn("Browser is NOT supported..");
		}
		
		//initializing the extent report
		Random rand= new Random();
		int max= 100;
		int ran= rand.nextInt(max) + 1;
		
		reportPath= System.getProperty("user.dir") + "/ExtentReport/report_"+ran+".html";
		reporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		
		log.info("Launched the application");
		driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		log.info("closing the browser");
		driver.quit();
	}
}
