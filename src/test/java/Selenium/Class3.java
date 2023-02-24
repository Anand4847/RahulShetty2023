package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class3 {
	

	@BeforeTest
	
	public void cleancode()
	{
		
		System.out.println("I will execute second");
	}
		
@BeforeClass
	
	public void beforeclas()
	
	{
		
		System.out.println("It will execute before any method in the class");
	}

		@Test(groups="Smoke")
		public void home1()

		{

			System.out.println("Home loan 1");
		}
		
		@Test
		public void home2()

		{

			System.out.println("Home loan 2");
		}
		
		@Test
		public void home3()

		{

			System.out.println("Home loan 3");
		}
		
		@BeforeSuite
		
		public void beforesuite()
		{
			
			System.out.println("I will execute before all the test methods as i am a suite");
		}
		
		@Test
		public void home4()

		{

			System.out.println("Home loan 4");
		}
		
		
		

		
		@AfterTest
		
		public void cleancode1()
		{
			
			System.out.println("I will execute after second test");
		}
}
