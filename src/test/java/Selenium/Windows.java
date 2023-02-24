package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windows {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	WebDriverWait wait  = new WebDriverWait(driver, 5);
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Click Here')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']")).getText());
		
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.quit();
		
		
		
	}
	
	

}
