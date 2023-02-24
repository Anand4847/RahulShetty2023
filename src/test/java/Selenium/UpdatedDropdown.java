package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		WebElement adult = driver.findElement(By.id("hrefIncAdt"));

		// for loop

//		for (int i= 1 ;i <=2;i++)
//		{
//		
//			adult.click();
//			
//			
//		}

		// While loop

		int i = 1;

		while (i < 3)

		{
			adult.click();
			i++;

		}

		Thread.sleep(3000);
		String option = driver.findElement(By.id("divpaxinfo")).getText();

		if (option.equalsIgnoreCase("3 Adult"))

		{

			Assert.assertTrue(true);
			System.out.println("It is passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("It is failed");
		}
		driver.quit();
	}
}
