package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select s = new Select(dropdown);
		 s.selectByIndex(3);
		 System.out.println(s.getFirstSelectedOption().getText());
		 Thread.sleep(3000);
		 s.selectByVisibleText("INR");
		 System.out.println(s.getFirstSelectedOption().getText());
		 Thread.sleep(3000);
		 s.selectByValue("AED");
		 System.out.println(s.getFirstSelectedOption().getText());
		 driver.quit();
		
	}

}
