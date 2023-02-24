package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonAction {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement searchbox = driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));

		Actions a = new Actions(driver);
		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	
		// Right CLick
		
		WebElement rightclick = driver.findElement(By.id("nav-link-accountList"));
		
		a.moveToElement(rightclick).contextClick().build().perform();
		
		
	}

}
