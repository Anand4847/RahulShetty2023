package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractCompo.AbstractComponents;
import BaseComponent.BaseClass;
import PageObjects.CartPage;
import PageObjects.CataloguePage;
import PageObjects.Header;

public class ErrorValidations extends BaseClass {

	@Test

	public void Loginerrorvalidation() throws Exception

	{

		lp.loginApplication("anandsoni@test.com", "Tes@123");
		Assert.assertEquals("Incorrect email or password.", lp.geterrormsg());

	}
	
	
	@Test

	public void Loginerrorvalidation1() throws Exception

	{

		lp.loginApplication("anandsoni@tes.com", "Test@123");
		Assert.assertEquals("Incorrect email or password.", lp.geterrormsg());

	}
	
	@Test

	public void Loginpasswordblank() throws Exception

	{

		lp.loginApplication("anandsoni@tes.com", "");
		Assert.assertEquals("*Password is required", lp.passworderror());

	}
	
	@Test

	public void Loginemailblank() throws Exception

	{

		lp.loginApplication("", "Test@123");
		Assert.assertEquals("*Email is required", lp.emailerror());

	}

	@Test

	public void Producterrorvalidation() throws Exception

	{
		String proname = "ADIDAS ORIGINAL";
		CataloguePage ct = lp.loginApplication("anandsoni@test.com", "Test@123");
		List<WebElement> products = ct.getproductlist();
		ct.productname(proname);
		AbstractComponents ab = new AbstractComponents(driver);
		ab.threadsleep();
		Header h = new Header(driver);
		h.addtocartbtn();
		ab.threadsleep();
		CartPage cp = new CartPage(driver);
		List<WebElement> productcart = cp.productcart();

		for (int i = 0; i < productcart.size(); i++)

		{

			String cartpro = productcart.get(i).getText();

			System.out.println(cartpro);

			if (cartpro.equalsIgnoreCase(proname)) {

				s.assertTrue(true);

			}

			else

			{
				s.assertTrue(false);

			}

		}
	}
	

}
