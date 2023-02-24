package TestCases;

import java.util.HashMap;
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
import PageObjects.OrdersPage;

public class Framework extends BaseClass {

	public OrderPlaced op;
	public OrdersPage opg;
	public Header hp;

	@Test(dataProvider = "getData")

	public void submitorder(HashMap<String, String> input) throws Exception

	{

		CataloguePage ct = lp.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = ct.getproductlist();
		ct.productname(input.get("product"));
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

			if (cartpro.equalsIgnoreCase(input.get("product"))) {

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
		cop.emailsend(input.get("email"));
		cop.countryname("India");
		cop.countryselect();
		op = cop.placeorder();
		ab.threadsleep();
		String thanks = op.thankyou().getText();
		op.messagevalidation(thanks);

	}

	@DataProvider

	public Object[][] getData() throws Exception

	{

		List<HashMap<String, String>> data = getjsondataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Data\\data.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

		// With the help of hashmap we can send the values

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "anandsoni@test.com");
//		map.put("password", "Test@123");
//		map.put("product", "IPHONE 13 PRO");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "sameer@test.com");
//		map1.put("password", "Sameer@123");
//		map1.put("product", "ZARA COAT 3");
//		return new Object[][] { { map }, { map1 } };	

		// @DataProvider [with the help of data provider we can send the values]

//		public Object[][] getData()
//		
//		{
//			
//			return new Object[][] {{"anandsoni@test.com","Test@123","IPHONE 13 PRO"},{"sameer@test.com","Sameer@123","ZARA COAT 3"}} 
//		}
//		
	}

}
