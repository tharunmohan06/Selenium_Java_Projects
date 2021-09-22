package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AlertBox {
	
	public static void main(String[] args) throws InterruptedException 
	{
		singleOptionAlertBox();
		multipleOptionAlertBox();
		enterNameAlertBox("Tharun");	
	}
	
	public static void singleOptionAlertBox() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void multipleOptionAlertBox() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click me!']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		String lab= driver.findElement(By.id("confirm-demo")).getText();
		Assert.assertEquals("You pressed OK!", lab);
		//Assert.assertEquals("You pressed Cancel!", lab);
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public static void enterNameAlertBox(String name) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click for Prompt Box']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		
		String lab2= driver.findElement(By.id("prompt-demo")).getText();
		Assert.assertEquals("You have entered '"+name+"' !", lab2);
		
		Thread.sleep(3000);
		driver.quit();
	}
}
