package Selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sorting {

	@Test

	public void sorting() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on the coloum

		driver.findElement(By.xpath("//th[@role='columnheader']")).click();

		// get the list of webelement

		List<WebElement> names = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));

		// get the text of all the listed names into original list

		List<String> originalist = names.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list

		List<String> sortedlist = originalist.stream().sorted().collect(Collectors.toList());

		// compare sorted list with original list

		Assert.assertTrue(originalist.equals(sortedlist));

		driver.quit();

	}

}
