package Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
	
	@Test
	public void demo1()
	
	{
		
		System.out.println("I will get pass");
		Assert.assertTrue(true);
	}
	
	@Test
	public void demo2()
	
	{
		
		System.out.println("I will get failed");
		Assert.assertTrue(false);
	}

}
