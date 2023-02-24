package Selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplexAutomation {

	public static void main(String[] args) throws Exception {

		int j = 0;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Brinjal", "Carrot" };

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> allproducts = driver.findElements(By.cssSelector("[class='product-name']"));

		for (int i = 0; i < allproducts.size(); i++)

		{

			String[] name = allproducts.get(i).getText().split("-");

			// Seperating the 1 kg from the product names

			String FormattedName = name[0].trim();

			// Convert array to arraylist for easy search

			List itemsNeededlist = Arrays.asList(itemsNeeded);

			if (itemsNeededlist.contains(FormattedName))

			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length)
					break;

			}
		}

	}
}
