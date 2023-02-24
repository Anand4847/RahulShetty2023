package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractCompo.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	SoftAssert s = new SoftAssert();

	public CartPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> productcart;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutbtn;

	public List<WebElement> productcart()

	{

		return productcart;
	}

	

	public CheckoutPage checkoutbtn() throws Exception

	{

		checkoutbtn.click();
		return new CheckoutPage(driver);
		 

	}

}
