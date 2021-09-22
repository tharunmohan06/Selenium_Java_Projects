package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		WebElement frame = driver.switchTo().frame("mce_0_ifr").findElement(By.xpath("//body[@id='tinymce']/p"));
		frame.clear();
		frame.sendKeys("This is to test frames...");
		
		Thread.sleep(2000);
		driver.close();
	}

}
