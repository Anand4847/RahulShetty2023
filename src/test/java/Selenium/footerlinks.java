package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class footerlinks {
	
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.cssSelector("[class=' footer_top_agile_w3ls gffoot footer_style']"));
		
		int footerlinks = footer.findElements(By.tagName("a")).size();

		
		
		System.out.println(footerlinks);
		
		// links count of first section
		
		WebElement firstsection = driver.findElement(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']/table/tbody/tr/td"));
		
		List <WebElement> selection = firstsection.findElements(By.tagName("a"));
		int fsection = firstsection.findElements(By.tagName("a")).size();

		
		System.out.println(fsection);
		
		for (int i=1 ; i<fsection; i++)
			
		{
	
			 String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			selection.get(i).sendKeys(clickonlink);
	
			
			
		}
		
		
	
		
		
		
		//driver.quit();
		
		
	}

}
