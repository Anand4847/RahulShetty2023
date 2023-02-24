package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		String password = getpassword(driver);
		String name = "Rahul";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);

		Thread.sleep(3000);
		driver.findElement(By.className("submit")).click();

	}

	public static String getpassword(WebDriver driver) throws Exception

	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		Thread.sleep(3000);
		String password = driver.findElement(By.className("infoMsg")).getText();

		String[] pass1 = password.split("'");

		String[] pass2 = pass1[1].split("'");

		driver.findElement(By.className("go-to-login-btn")).click();

		String passwordnew = pass2[0];
		return passwordnew;

	}
}
