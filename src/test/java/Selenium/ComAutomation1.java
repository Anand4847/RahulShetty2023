package Selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComAutomation1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int j = 0;
		String[] ItemsNeeded = { "Cucumber", "Beetroot" };
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

		List<WebElement> allproducts = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < allproducts.size(); i++)

		{

			// Splitting the name with 1 kg
			String[] formattedname = allproducts.get(i).getText().split("-");

			// Trimming the name

			String allpro = formattedname[0].trim();

			// Array to arraylist

			List ItemsList = Arrays.asList(ItemsNeeded);

			if (ItemsList.contains(allpro))

			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == allpro.length()) {

					break;
				}
			}

		}

	}
}
