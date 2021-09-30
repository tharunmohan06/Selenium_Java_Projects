package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptTest 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();	
		
		/*scrollBy(x, y)
		 * (0,10)  >> scroll to down by 10 pixel
		 * (0,-10) >> scroll to up by 10 pixel
		 * (10,0)  >> scroll from left to right by 10 pixel
		 * (-10,0) >> scroll from right to left by 10 pixel
		 */
				
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
	
		//this will scroll until the web element is visible
		WebElement element= driver.findElement(By.xpath("//a[text()='Linda.Anderson']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		//this will scroll until bottom
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
				
		driver.quit();
	}
}
