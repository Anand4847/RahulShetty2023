package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToughAutomation {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebDriverWait wait = new WebDriverWait(driver, 5);
		String username = "rahulshettyacademy";

		String password = "learning";
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector("[id='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("[id='password']")).sendKeys(password);

		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span")).click();

	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

		driver.findElement(By.id("okayBtn")).click();

		WebElement Sel = driver.findElement(By.xpath("//select[@class='form-control']"));

		Select s = new Select(Sel);
		s.selectByValue("consult");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("signInBtn")).click();

	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='nav-link btn btn-primary']")));

		List<WebElement> allpro = driver.findElements(By.cssSelector("[class='btn btn-info']"));

		for (int i = 0; i < allpro.size(); i++)

		{

			allpro.get(i).click();

		}

		driver.findElement(By.cssSelector("[class='nav-link btn btn-primary']")).click();
		
	}

}
