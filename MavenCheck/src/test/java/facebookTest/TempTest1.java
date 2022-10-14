package facebookTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facebook.HomePage;
import facebook.MessengerPage;
import facebook.RoomsPage;

public class TempTest1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		HomePage homePage = new HomePage(driver);
		homePage.openMessenger();
		String messengerPageURL1 = driver.getCurrentUrl();
		String messengerPageTitle1 = driver.getTitle();
		if (messengerPageURL1.equals("https://www.messenger.com/") && messengerPageTitle1.equals("Messenger"))
		{
			System.out.println("Test step pass");
		}
		
		else
		{
			System.out.println("Test step failed");
		}
		
		MessengerPage messengerPage = new MessengerPage(driver);
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
			
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.returnToMessenger();
		
		String messengerPageURL2 = driver.getCurrentUrl();
		String messengerPageTitle2 = driver.getTitle();
		
		if (messengerPageURL2.equals("https://www.messenger.com/") && messengerPageTitle2.equals("Messenger"))
		{
			System.out.println("Test case is verified succesfully");
		}
		
		else
		{
			System.out.println("Test case is failed");
		}
		
	}

}
