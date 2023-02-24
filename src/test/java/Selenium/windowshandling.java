package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowshandling {
	
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		
		JavascriptExecutor js =  (JavascriptExecutor)driver ;
		js.executeScript("window.scrollBy(0,2000)");
		
		
		Thread.sleep(3000);
		String coursename = driver.findElement(By.xpath("//div[@class='upper-box']/h2/a")).getText();
		
		System.out.println(coursename);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys(coursename);
		
		String name = driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).getAttribute("form-control ng-untouched ng-pristine ng-invalid");
		

		
		
		System.out.println(name);
		
		
		
		
		
		
	driver.quit();
		
	}

}
