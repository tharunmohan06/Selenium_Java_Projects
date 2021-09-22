package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	
	public static void main(String[] args) throws InterruptedException {
	
		//selectUser("Garry");
		selectDateFromCalander("2020","Dec","25");
	}
	
	public static void selectUser(String name) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();	
		String element= driver.findElement(By.linkText(name)).getText();
		driver.findElement(By.xpath("//a[text()='"+element+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	public static void selectDateFromCalander(String year, String month, String date) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b")).click();
		
		//selecting start date
		driver.findElement(By.id("calFromDate")).click();
		Thread.sleep(2000);
		
		WebElement mnthDrp= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select drp1= new Select(mnthDrp);
		drp1.selectByVisibleText(month);
		
		WebElement yearDrp= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select drp2= new Select(yearDrp);
		drp2.selectByVisibleText(year);
		
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+date+"']")).click();
		
		
		//selecting end date
		driver.findElement(By.id("calToDate")).click();
		Thread.sleep(5000);
		
		WebElement mnthDrp1= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select drp3= new Select(mnthDrp1);
		drp3.selectByVisibleText(month);
		
		WebElement yearDrp1= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select drp4= new Select(yearDrp1);
		drp4.selectByVisibleText(year);
		
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+date+"']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
