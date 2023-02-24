package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// child sibling

		String text = driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']//following-sibling::button[1]")).getText();
		
		
		System.out.println(text);
		
		// parent sibling
		  
		
		
		
	}

}
