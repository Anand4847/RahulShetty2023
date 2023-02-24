package Selenium;

import java.net.HttpURLConnection;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void main(String[] args) throws Exception, Exception {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String url = driver.findElement(By.cssSelector("[href='https://rahulshettyacademy.com/brokenlink']")).getAttribute("href");
		
		
		
		// Setting the http connection
		
		HttpURLConnection connection  = (HttpURLConnection)new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int respcode = connection.getResponseCode();
		System.out.println(respcode);
				
		driver.quit();
		
	}

}
