package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Standalone {

	@Test

	public void stand() throws Exception

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String proname = "ADIDAS ORIGINAL";
		driver.manage().window().maximize();
		SoftAssert s = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String username = "anandsoni@test.com";
		String password = "Test@123";

		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[id='login']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//h5[@style='text-transform: uppercase;']"));

		for (int i = 0; i < products.size(); i++)

		{

			if (products.get(i).getText().equalsIgnoreCase(proname))

			{

				driver.findElements(By.cssSelector("[class='btn w-10 rounded']")).get(i).click();
			}

		}

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		Thread.sleep(3000);

		List<WebElement> productcart = driver.findElements(By.cssSelector(".cartSection h3"));

		for (int i = 0; i < productcart.size(); i++)

		{

			String cartpro = productcart.get(i).getText();

			System.out.println(cartpro);

			if (cartpro.equalsIgnoreCase(proname)) {

				s.assertTrue(true);

			}

			else

			{
				s.assertTrue(false);

			}

		}

		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("[class='input txt text-validated']")).clear();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("[class='input txt text-validated']")).sendKeys("4111 1111 1111 1111");

		Select sa = new Select(driver.findElement(By.xpath("//select[@class='input ddl']")));
		sa.selectByIndex(7);

		Select sa1 = new Select(driver.findElement(By.xpath("//select[@class='input ddl'][2]")));
		sa1.selectByIndex(7);

		driver.findElement(By.cssSelector("[class='input txt']")).sendKeys("123");

		driver.findElement(By.xpath("//div[contains(text(),'Name on Card ')]/following-sibling::input"))
				.sendKeys("Anand Soni");

		driver.findElement(By.xpath("//div[@class='user__name mt-5']/input")).clear();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='user__name mt-5']/input")).sendKeys("anand@test.com");

		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]/span/i")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click();

		String thanks = driver.findElement(By.cssSelector("[class='hero-primary']")).getText();

		if (thanks.equalsIgnoreCase("THANKYOU FOR THE ORDER."))

		{

			s.assertTrue(true);
		}

		else

		{

			s.assertTrue(false);
		}

		s.assertAll();

		driver.quit();
	}

}
