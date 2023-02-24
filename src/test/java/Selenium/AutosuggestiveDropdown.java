package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected());

		boolean checkbox = driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected();
		System.out.println(checkbox);
		Assert.assertFalse(false);

		driver.findElement(By.cssSelector("[id*='friendsandfamily']")).click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected());
		boolean checkbox1 = driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected();
		System.out.println(checkbox1);
		Assert.assertTrue(true);

		driver.quit();

	}
}
