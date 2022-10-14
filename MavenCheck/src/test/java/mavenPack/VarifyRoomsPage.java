package mavenPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import facebook.HomePage;
import facebook.MessengerPage;
import facebook.RoomsPage;
import setup.Base;

public class VarifyRoomsPage extends Base {
	private WebDriver driver;          //WebDriver->dataType    driver->global ref. variable
	private RoomsPage roomsPage;
	private HomePage homePage; 
	private MessengerPage messengerPage; 
	private SoftAssert soft;
	
	@Parameters ("browser")
	@BeforeTest   // all browsers keys and values for cross browser testing
	public void launchBrowser(String browserName)
	{
		if (browserName.equals("chromeBrowser"))
		{
			driver = openChromeBrowser();
		}
		
		if (browserName.equals("firefoxBrowser"))
		{
			driver = openFirefoxBrowser();
		}
		
		if (browserName.equals("operaBrowser"))
		{
			driver = openOperaBrowser();
		}
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObjects()
	{
		homePage = new HomePage(driver);
		messengerPage = new MessengerPage(driver);
		roomsPage = new RoomsPage(driver);
		soft = new SoftAssert();    //initialization of SoftAssert object	
	}
	
	@BeforeMethod
	public void openRoomsPage()
	{
		driver.get("https://www.facebook.com/");
		homePage.openMessenger();
		String messengerPageURL = driver.getCurrentUrl();
		String messengerPageTitle = driver.getTitle();
		if (messengerPageURL.equals("https://www.messenger.com/") && messengerPageTitle.equals("Messenger"))
		{
			System.out.println("Test step pass");
		}
		else
		{
			System.out.println("Test step failed");
		}
		messengerPage.openRooms();
		String roomPageURL = driver.getCurrentUrl();
		String roomPageTitle = driver.getTitle();
		
		if (roomPageURL.equals("https://www.messenger.com/rooms") && roomPageTitle.equals("Messenger | Page Not Found"))
		{
			System.out.println("Test step pass");
		}
		else
		{
			System.out.println("Test step failed");
		}
		  
	}
	
	
	@Test (priority = 1)
	public void varifyReturnToMessengerButton()
	{
		roomsPage.returnToMessenger();
		
		String messengerPageURL = driver.getCurrentUrl();
		String messengerPageTitle = driver.getTitle();
		// Hard Assert =>   actual result below | expected result below
		Assert.assertEquals(messengerPageURL, "https://www.messenger.com/","Messenger Page URL is NOT verified");
		Assert.assertEquals(messengerPageTitle, "Messenger","Messenger Page title is NOT verified");
		

	}
	
	@Test (priority = 0, dependsOnMethods = {"varifyReturnToMessengerButton"})
	public void varifyVisitOurHelpCenterButton() 
	{
		roomsPage.visitOurHelpCenter();
		
		String visitOurHelpCenterURL = driver.getCurrentUrl();
		String visitOurHelpCenterTitle = driver.getTitle();
		
		// Soft assert =>
		soft.assertEquals(visitOurHelpCenterURL,"https://www.messenger.com/help","visit to our help center url is NOT verified");
		soft.assertEquals(visitOurHelpCenterTitle,"Messenger Help Centre","visit to our help center title is NOT verified");
		soft.assertAll();   // compulsory required to execute all soft asserts

	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("logout");
	}
	
	@AfterClass
	public void closePOMObjects()
	{
		homePage = null;
		messengerPage = null;
		roomsPage = null;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
}
