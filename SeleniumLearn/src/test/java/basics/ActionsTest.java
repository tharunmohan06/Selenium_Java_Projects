package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		//actionsExp1();
		actionsExp2();		
		
		/* create object for action class
		 * moveToElement() >> used to move the pointer 
		 * keyDown() >> used to press a key
		 * keyUp() >> used to release a key
		 * build().perform() >> always need to use
		 * doubleClick() >> used to double click
		 * 
		 */
	}
	
	
	public static void actionsExp1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		WebElement username= driver.findElement(By.id("txtUsername"));
		
		Actions action= new Actions(driver);
		action.moveToElement(username).click().keyDown(Keys.SHIFT).sendKeys("admin").keyUp(Keys.SHIFT).doubleClick().build().perform();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void actionsExp2() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions act= new Actions(driver);
		
		WebElement frame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		WebElement source= driver.switchTo().frame(frame).findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest= driver.switchTo().frame(frame).findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(source, dest).build().perform();
		
	}

}
