package Selenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class4 {

	@Parameters("URL")
	@Test

	public void teest(String urlname)

	{

		System.out.println("Call me 2nd" + urlname);
	}

	@Test

	public void teeast()

	{

		System.out.println("Call me 1st");
	}

	@Test(dependsOnMethods = { "teeast", "teest", "teesat" })

	public void teesqt()

	{

		System.out.println("Call me 4th");
	}

	@Test

	public void teesat()

	{

		System.out.println("Call me 3rd");
	}

}
