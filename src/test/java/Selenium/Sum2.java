package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sum2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.cssSelector("[name='courses'] tr"));

		int totalrows = rows.size();

		System.out.println(totalrows);

		
		
		
	  List <WebElement> col = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		
	  int coloums = col.size();
	  
	  System.out.println(coloums);
		

	  String second = driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText();
	  
	  System.out.println(second);
	  
	  
	  
	  
	  
	  
	  
	  driver.quit();
		
	}

}
