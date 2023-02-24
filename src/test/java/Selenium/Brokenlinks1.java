package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks1 {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		SoftAssert a = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector("[class='gf-li']"));

		for (WebElement link : links)

		{

			String url = link.getAttribute("href");

			// Setting the http connection

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int respcode = connection.getResponseCode();
			System.out.println(respcode); 

			a.assertTrue(respcode<400, "Link with text is broken\" + link.getText() + \"is broken with resp code\" + respcode");
			
		
		}
		a.assertAll();
		driver.quit();
	}

	
}
