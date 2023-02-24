package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractCompo.AbstractComponents;

public class OrdersPage extends AbstractComponents {

	WebDriver driver;
	SoftAssert s = new SoftAssert();

	public OrdersPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> productnames;

	public List<WebElement> productnames()

	{

		return productnames;
	}

	public  boolean productmatch()
	
	{

		for (WebElement pro : productnames)
		 
		{
		
			pro.getText().equalsIgnoreCase("IPHONE 13 PRO");
						
		}
		return false;
	}
	
}
