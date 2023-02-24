package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QAClick {
	
public static void main(String[] args) {
	

	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.findElement(By.id("checkBoxOption2")).click();
	System.out.println(driver.findElement(By.xpath("//label[@for='benz']")).getText());
	
	String text = driver.findElement(By.xpath("//label[@for='benz']")).getText();
	WebElement sel = driver.findElement(By.id("dropdown-class-example"));
	
	Select s = new Select(sel);
	s.selectByVisibleText(text);
	
	driver.findElement(By.cssSelector("[id='name']")).sendKeys(text);
	
	driver.findElement(By.id("alertbtn")).click();
	
	System.out.println(driver.switchTo().alert().getText());
	
	String alert= driver.switchTo().alert().getText();
	
	
	if (alert.contains("Option2"))
	
		
	{
		
		System.out.println("Option2 is present");
		
	}
	else
		
	{
		
		System.out.println("Option2 is not present");
	}
	
	driver.quit();
	
	
}

}
