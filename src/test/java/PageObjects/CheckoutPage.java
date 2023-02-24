package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractCompo.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='input txt text-validated']")
	WebElement carddetails;

	@FindBy(xpath = "//select[@class='input ddl']")
	WebElement month;

	@FindBy(xpath = "//select[@class='input ddl'][2]")
	WebElement date;

	@FindBy(css = "[class='input txt']")
	WebElement cvv;

	@FindBy(xpath = "//div[contains(text(),'Name on Card ')]/following-sibling::input")
	WebElement nameoncard;

	@FindBy(xpath = "//div[@class='user__name mt-5']/input")
	WebElement email;

	@FindBy(xpath = "//div[@class='user__name mt-5']/input")
	WebElement emailsend;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryname;
	
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][2]/span/i")
	WebElement countryselect;
	
	@FindBy (xpath ="//a[contains(text(),'Place Order ')]")
    WebElement placeorder;
	
	
	public OrderPlaced placeorder()

	{

		placeorder.click();
		return new OrderPlaced(driver);
		 
	}

	
	
	public void countryselect()

	{

		countryselect.click();
	}

	
	public void countryname(String country)

	{

		countryname.sendKeys(country);
	}

	public void emailsend(String email)

	{

		emailsend.sendKeys(email);
	}

	public void email()

	{

		email.clear();

	}

	public void nameoncard(String name)

	{

		nameoncard.sendKeys(name);

	}

	public void cvv(String cv)

	{

		cvv.sendKeys(cv);

	}

	public void carddetails()

	{

		carddetails.clear();
	}

	public void carddetails1()

	{

		carddetails.sendKeys("4111 1111 1111 1111");
	}

	public void checkoutexpiry() throws Exception

	{

		Select sa = new Select(month);
		sa.selectByIndex(6);

		AbstractComponents ab = new AbstractComponents(driver);
		ab.threadsleep();

		Select sa1 = new Select(date);
		sa1.selectByIndex(6);

	}

}
