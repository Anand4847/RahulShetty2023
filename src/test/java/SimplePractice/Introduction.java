package SimplePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Introduction {

	public static void main(String[] args) {

		// Execute with ChromeDriver

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

// Execute with FirefoxDriver

//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
//	WebDriver driver = new FirefoxDriver();

//		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.rahulshettyacademy.com/courses");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
