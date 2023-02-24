package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		String password = getpassword(driver);

		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(password);

		Thread.sleep(3000);
		driver.findElement(By.className("submit")).click();

	}

	public static String getpassword(WebDriver driver) throws Exception {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(3000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String password = driver.findElement(By.className("infoMsg")).getText();

		System.out.println(password);

		String[] pass = password.split("'");

		// 0th Index = Please use temporary password
		// 1st Index = rahulshettyacademy' to Login.

		String[] passwordnew = pass[1].split("'");

		// 0th Index = rahulshettyacademy
		// 1st Index = ' to Login.
		driver.findElement(By.className("go-to-login-btn")).click();
		String passwordsent = passwordnew[0];
		return passwordsent;
		


	}
}
