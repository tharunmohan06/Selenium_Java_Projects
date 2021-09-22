package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngTest {
	
	
	//suite, test, method, class
	
	@BeforeSuite
	public void setup()
	{
		System.out.println("This is before suite...");
	}
	
	@AfterSuite
	public void tearDown()
	{
		System.out.println("This is after suite...");
	}
	
	@Test(priority = 2, groups = "sanity")
	public void test1()
	{
		System.out.println("This is test 1...");
	}
	
	@Test(priority = 1)
	public void test2()
	{
		System.out.println("This is test 2...");
	}
	
	@Test(dependsOnMethods = "test1", groups = "sanity")
	public void test3()
	{
		System.out.println("This is test 3...");
	}

	@BeforeMethod
	public void methodtest()
	{
		System.out.println("This is before method..");
	}
	
	@AfterMethod
	public void methodtest2()
	{
		System.out.println("This is after method..");
	}
	
	@BeforeTest
	public void bftest()
	{
		System.out.println("This is before test..");
	}
	
	@AfterTest
	public void aftest()
	{
		System.out.println("This is after test..");
	}
	
	@BeforeClass
	public void classtest()
	{
		System.out.println("This is before class..");
	}
	
	@AfterClass
	public void classtest2()
	{
		System.out.println("This is after class..");
	}
}
