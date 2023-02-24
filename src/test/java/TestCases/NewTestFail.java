package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractCompo.AbstractComponents;
import BaseComponent.BaseClass;
import PageObjects.CartPage;
import PageObjects.CataloguePage;
import PageObjects.CheckoutPage;
import PageObjects.Header;
import PageObjects.OrderPlaced;

public class NewTestFail extends BaseClass {

	
	public OrderPlaced op;
	
	@Test(dataProvider = "getData") 

	public void NewTestFail(String email, String password, String product) throws Exception

	{

		CataloguePage ct = lp.loginApplication(email, password);
		List<WebElement> products = ct.getproductlist();
		ct.productname(product);
		AbstractComponents ab = new AbstractComponents(driver);
		ab.threadsleep();
		Header h = new Header(driver);
		h.addtocartbtn();
		ab.threadsleep();
		ab.scroll();
		CartPage cp = new CartPage(driver);
		List<WebElement> productcart = cp.productcart();

		for (int i = 0; i < productcart.size(); i++)

		{

			String cartpro = productcart.get(i).getText();

			System.out.println(cartpro);

			if (cartpro.equalsIgnoreCase(product)) {

				s.assertTrue(true);

			}

			else

			{
				s.assertTrue(false);

			}

		}

		CheckoutPage cop = cp.checkoutbtn();
		ab.threadsleep();
		ab.scroll();
		cop.carddetails();
		ab.threadsleep();
		cop.carddetails1();
		cop.checkoutexpiry();
		cop.cvv("123");
		cop.nameoncard("Soni");
		cop.email();
		ab.threadsleep();
		cop.emailsend(email);
		cop.countryname("India");
		cop.countryselect();
		op = cop.placeorder();
		ab.threadsleep();
		String thanks = op.thankyou().getText();
		op.messagevalidation(thanks);

	}

	@DataProvider

	public Object[][] getData() {

		
		Object map[][] = new Object[1][3];
		
		map[0][0] = "anand@eteistn.com";
		map[0][1] = "Test@123";
		map[0][2] = "Zara 3";
		return map;
		
		
		
		
	}
}
