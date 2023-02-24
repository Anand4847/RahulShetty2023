package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {

	@Test(groups="Smoke")
	public void car1()

	{
  
		System.out.println("Car loan 1");
	}
	
	@AfterClass
	
	public void Afterclas()
	
	{
		
		System.out.println("It will execute after all the method get executed in the class");
	}
	
	
	
	
	@Test(groups="Smoke")
	public void car2()

	{

		System.out.println("Car loan 2");
	}
	
	@BeforeMethod
	
	public void beforem()
	
	{
		
		System.out.println("I will execute before every test method gets executed");
	}
	@BeforeTest
	
	public void cleancode()  
	{
		
		System.out.println("I will execute first");
	}
	

	@AfterSuite
	
	public void aftersuite()
	{
		
		System.out.println("I will execute after all test method gets executed as i am a suite");
	}
	@AfterMethod
	
	public void afterm()
	
	{
		
		System.out.println("I will execute after every test method gets executed");
	}


}
