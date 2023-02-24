package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractCompo.AbstractComponents;

public class Header extends AbstractComponents {

	WebDriver driver;
	SoftAssert s = new SoftAssert();

	public Header(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement addtocartbtn;
	
	@FindBy (css = "[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	public void orders()

	{

		 orders.click();
	}
	
	public Header addtocartbtn() {

		addtocartbtn.click();
		Header h = new Header(driver);
		return h;

		
	}

}
