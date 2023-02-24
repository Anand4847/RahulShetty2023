package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownprac {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys("IND");

		Thread.sleep(2000);

//		 driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys(Keys.DOWN);

		// driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys(Keys.DOWN);

		// String value =
		// driver.findElement(By.cssSelector("[id='autocomplete']")).getAttribute("value");

//		 Using javascript executor to enter in text box

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('autocomplete').value='IND'");
//		 Using javascript executor to get the value from the text box

		String value = (String) js.executeScript("return document.getElementById('autocomplete').value='IND'");		
		
		System.out.println(value);
         		
		driver.quit();

	}

}
