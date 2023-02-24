package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sum {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);

		List<WebElement> num = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < num.size(); i++)

		{

			sum = sum + Integer.parseInt((num).get(i).getText());

		}
		System.out.println(sum);

		// ******************************************************************//

		String totalamt = driver.findElement(By.cssSelector("[class='totalAmount']")).getText();

		System.out.println(totalamt);

		String[] newamt = totalamt.split(":");

		String new1 = newamt[0];
		String amount = newamt[1].trim();

		int newamount = Integer.parseInt(amount);

		System.out.println(newamount + " is a new amount");

		Assert.assertEquals(sum, newamount);

		driver.quit();
	}

}
