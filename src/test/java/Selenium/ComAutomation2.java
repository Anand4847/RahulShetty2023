package Selenium;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ComAutomation2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String[] ProductRequired = { "Apple", "Beetroot", "Beans", "Cauliflower" };
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		additems(driver, ProductRequired);

	}

	public static void additems(WebDriver driver, String[] ProductRequired) {
		int j = 0;

		// Getting the list of all products
		List<WebElement> allpro = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < allpro.size(); i++) {

			// Splitting the names of a product
			String[] pronames = allpro.get(i).getText().split("-");

			// Trimming the product names with 1 kg
			System.out.println(pronames[0].trim());

			String Itemslist = pronames[0].trim();

			List Items = Arrays.asList(ProductRequired);

			if (Items.contains(Itemslist)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == Itemslist.length())

				{
					break;

				}

			}

		}

		driver.findElement(By.cssSelector("[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

	//	WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.className("promoBtn")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

		String promo = driver.findElement(By.className("promoInfo")).getText();

		if (promo.equalsIgnoreCase("Code applied ..!")) {

			Assert.assertTrue(true);
		} else

		{
			Assert.assertFalse(false);
		}

	}
}