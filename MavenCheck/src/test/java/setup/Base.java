package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	private static WebDriver driver; 
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe" );
		driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","F:\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver", "F:\\Selenium\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		driver=new OperaDriver();
		return  driver;
	}

}
