package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDrop {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANANDSON\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	WebDriverWait wait  = new WebDriverWait(driver, 5);
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		
		//Switching through webelement
		
		//driver.switchTo().frame(iframe);
		
		// Switching through index

		driver.switchTo().frame(0);
		
		WebElement elementdrop= driver.findElement(By.cssSelector("[id='droppable']"));
		WebElement elementdrag= driver.findElement(By.cssSelector("[id='draggable']"));
		Actions a = new Actions(driver);
		a.moveToElement(elementdrag).dragAndDrop(elementdrag, elementdrop).build().perform();

		driver.switchTo().defaultContent();
		
	}

}
