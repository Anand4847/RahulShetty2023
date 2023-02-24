package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractCompo.AbstractComponents;

public class OrderPlaced extends AbstractComponents {

	WebDriver driver;
	SoftAssert s = new SoftAssert();

	public OrderPlaced(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css ="[class='hero-primary']")
    WebElement thankyou;
	
	@FindBy (xpath = "//div[contains(text(),'adidas original')]")
	WebElement productname;
	
	

	public String productname()

	{

		return productname.getText();
	}
	
	
	public void messagevalidation(String thanks)
	
	{
		
		if (thanks.equalsIgnoreCase("THANKYOU FOR THE ORDER."))

		{

			s.assertTrue(true);
		}

		else

		{

			s.assertTrue(false);
		}

	}
	
	
	public WebElement thankyou()

	{

		return thankyou;
	}

}
