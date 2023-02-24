package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice {
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		boolean checkbox = driver.findElement(By.id("checkBoxOption1")).isSelected();
		System.out.println(checkbox);
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		boolean checkbox1 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		System.out.println(checkbox1);
		driver.quit();
	}

}
