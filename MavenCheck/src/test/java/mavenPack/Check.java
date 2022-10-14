package mavenPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Check  {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/?ie=UTF8&tag=googinprimeexpt5-21&ascsubtag=_k_CjwKCAjw9NeXBhAMEiwAbaY4lsMcCE761tTM18D094JZyy9tjrjXOlZHDTQ1Xy6EkamMyNhv60W-vhoCNvAQAvD_BwE_k_&gclid=CjwKCAjw9NeXBhAMEiwAbaY4lsMcCE761tTM18D094JZyy9tjrjXOlZHDTQ1Xy6EkamMyNhv60W-vhoCNvAQAvD_BwE");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement AccList = driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
		Thread.sleep(3000);
		WebElement wishlist = driver.findElement(By.xpath("//span[text()='Your Wish List']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(AccList).moveToElement(wishlist).click().build().perform();
		
	}
}
