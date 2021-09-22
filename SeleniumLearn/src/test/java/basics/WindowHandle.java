package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumframework.com/practiceform/");
		
		System.out.println("Parent window title is: "+ driver.getTitle());
		String parentWindow= driver.getWindowHandle();
		String childHandle= null;
		
		driver.findElement(By.xpath("//button[@id='button1']")).click();
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> items= handles.iterator();
		
		while(items.hasNext())
		{
		childHandle= items.next();
		driver.switchTo().window(childHandle);
		}
		
		System.out.println("Child window title is: "+ driver.getTitle());
		driver.switchTo().window(parentWindow);
		System.out.println("printing Parent window title again: "+ driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
