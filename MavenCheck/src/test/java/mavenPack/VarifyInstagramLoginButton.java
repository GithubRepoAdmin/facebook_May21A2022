package mavenPack;

import java.util.ArrayList;
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
import facebook.InstagramPage;
import setup.Base;

public class VarifyInstagramLoginButton extends Base {
	private WebDriver driver;
	private InstagramPage instagramPage;
	private HomePage homepage;
	private ArrayList<String> instagramChildBrowser;
	private String instagramPageURL;
	private String instagramPageTitle;
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeClass   // create all POM objects 
	public void createPOMObjects()
	{
		homepage = new HomePage(driver);
		
		instagramPage = new InstagramPage(driver);	
		soft = new SoftAssert();
	}
	
	@BeforeMethod  
	public void openInstagramLogInPage()
	{	
		driver.get("https://www.facebook.com/");
		homepage.openInstagram();
		instagramChildBrowser = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(instagramChildBrowser.get(1));
		
		
		
	}

	@Test
	public void verifyLogInButton()
	{
		instagramPage.sendTestData();
		instagramPage.logIn();
		instagramPageURL = driver.getCurrentUrl();
		System.out.println(instagramPageURL);
		instagramPageTitle = driver.getTitle();
		System.out.println(instagramPageTitle);
		soft.assertEquals(instagramPageURL, "https://www.instagram.com/", "Test step is failed");
		soft.assertEquals(instagramPageTitle,"Instagram", "Test step is failed");
		soft.assertAll();
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout");
	}
	
	@AfterClass  // delete all POM objects
	public void closePOMObjects()
	{
		homepage = null;
		instagramChildBrowser = null;
		instagramPage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
}
