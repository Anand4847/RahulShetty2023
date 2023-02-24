package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {
	
	
	public static void main(String[] args) {
		
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	WebDriverWait wait  = new WebDriverWait(driver, 5);
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();

		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='/frame_top']"));
		
		driver.switchTo().frame(frame1);
		
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.cssSelector("[id='content']")).getText());
		
		
	}

}
