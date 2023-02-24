package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Anand");
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("anand@test.com");
		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Testing");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.xpath("//select[@class='form-control']//option[1]")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("[name='bday']")).sendKeys("26111993");
		driver.findElement(By.cssSelector("[class='btn btn-success']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']")).isDisplayed());
		driver.quit();

	}

}
