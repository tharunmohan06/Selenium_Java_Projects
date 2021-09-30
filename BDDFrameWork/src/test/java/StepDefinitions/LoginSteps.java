package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps 
{
	WebDriver driver;
	
	@Given("User should be on login page")
	public void user_should_be_on_login_page()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	
	@When("User enters username and password")
	public void user_enters_username_and_password()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password); 
	}

	
	@When("clicks on login button")
	public void clicks_on_login_button()
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	
	@Then("User should be navigated to Dashboard page")
	public void user_should_be_navigated_to_dashboard_page() 
	{
		if (driver.getPageSource().contains("Dashboard"))
		{
			System.out.println("Login Success");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		driver.quit();
	}
}
