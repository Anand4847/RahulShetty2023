package BaseComponent;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public SoftAssert s = new SoftAssert();
	public Properties prop;
	public FileInputStream fis;
	public ExtentReports extent;
	public ExtentTest test;

	@Test

	public WebDriver initializedriver() throws Exception

	{

		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\globaldata.properties");
		prop.load(fis);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browsername.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;
	}

	public List<HashMap<String, String>> getjsondataToMap(String filepath) throws Exception

	{
		// read json to string
		String Jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// String to hashmap Jackson Datbind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(Jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@BeforeTest

	public void extentreport() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter ep = new ExtentSparkReporter(path);
		ep.config().setReportName("Web Automation Results");
		ep.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(ep);
		extent.setSystemInfo("Tester", "Anand Soni");
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchapplication() throws Exception {

		test = extent.createTest("Demo");
		driver = initializedriver();
		lp = new LoginPage(driver);

		lp.gotourl();
		return lp;

	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {
		s.assertAll();

		driver.quit();

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws Exception

	{

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"));
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

}
