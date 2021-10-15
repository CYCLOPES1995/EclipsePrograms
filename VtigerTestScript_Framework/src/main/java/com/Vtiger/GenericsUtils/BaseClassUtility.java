package com.Vtiger.GenericsUtils;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Vtiger.POM.HomePage;
import com.Vtiger.POM.LoginPage;
import com.beust.jcommander.Parameter;
/**
 * 
 * @author singh
 *
 */
public class BaseClassUtility {
	
	
	public DataBaseUtility dLib= new DataBaseUtility();
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public ExcelUtility elib= new ExcelUtility();
	public WebDriver  driver;
	public static  WebDriver staticDriver;
	
	/**
	 * 
	 * @throws Throwable
	 */
	
	@BeforeSuite(groups = "smoketest")
	public void connectDB() throws Throwable {
		//dLib.connectDB();
		System.out.println("===============================DB Connection successfull==============");

	}
	
	/**
	 * 
	 * @param browserValue
	 * @throws Throwable
	 */
	@Parameters(value = {"browserValue"})//chrome,firefox
	@BeforeClass(groups = {"smoketest","regression"})
	public void launchBrowser(@Optional("chrome") String browserValue) throws Throwable {
		//read data from property file
		//String BROWSER = flib.getJsonKeyValue("browser");
		String URL = flib.getJsonKeyValue("url");
		System.out.println("Launching browser:" + browserValue);
		if(browserValue.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		staticDriver = driver;
		System.out.println("===============browser launch successfully===============");
		driver.manage().window().maximize();
		wlib.waitUntilPageLoad(driver);
		driver.get(URL);
	}
	/**
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		// read data from property file
		String USERNAME = flib.getJsonKeyValue("username");
		String PASSWORD = flib.getJsonKeyValue("password");
		//login to app
		LoginPage lp= new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("==================login successfully=====================");
	}
	
	/**
	 * 
	 */
	@AfterMethod
	public void logoutOfApp() {
		//sign out of home page
		HomePage hp= new HomePage(driver);
		hp.signout();
		System.out.println("======================sign out successfully===============");

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("=================browser closed successfully============");
	}
	
	@AfterSuite
	public void closedDb() {
		//dLib.closeDb();
		System.out.println("======================DB connetion closed successfully==========");
	}

}
