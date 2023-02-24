package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompo.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errormessage;

	@FindBy(id = "userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(xpath = "//div[contains(text(),'*Password is required')]")
	WebElement passwordblank;

	@FindBy(xpath = "//div[contains(text(),'*Email is required')]")
	WebElement emailblank;

	public String emailerror() {

		return emailblank.getText();

	}

	public String passworderror() {

		return passwordblank.getText();

	}

	public CataloguePage loginApplication(String email, String password) {

		username.sendKeys(email);
		userpassword.sendKeys(password);
		login.click();

		return new CataloguePage(driver);

	}

	public String geterrormsg() {

		WaitforWebElementtoappear(errormessage);
		return errormessage.getText();

	}

	public void gotourl() {

		driver.get("https://rahulshettyacademy.com/client/");

	}

}
