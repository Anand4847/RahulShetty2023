package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompo.AbstractComponents;

public class CataloguePage extends AbstractComponents {

	WebDriver driver;

	public CataloguePage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[@style='text-transform: uppercase;']")
	List<WebElement> products;

	@FindBy(css = "[class='btn w-10 rounded']")
	List<WebElement> addtocart;

	


	public List<WebElement> getproductlist() {

		return products;
	}

	public List<WebElement> addtocart() {

		return addtocart;
	}

	public void productname(String proname) throws Exception

	{

		for (int i = 0; i < products.size(); i++)

		{

			if (products.get(i).getText().equalsIgnoreCase(proname))

			{

				addtocart.get(i).click();
			}

		}
		

	}

}
