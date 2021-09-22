package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("tharunmohan06@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("18may@1990");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
