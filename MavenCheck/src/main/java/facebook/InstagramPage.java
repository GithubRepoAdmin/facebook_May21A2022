package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstagramPage {
	
	@FindBy (xpath = "//input[@aria-label='Phone number, username, or email']")
	private WebElement PhoneNumberUsernameOrEmailField;
	
	@FindBy (xpath = "//input[@aria-label='Password']")
	private WebElement PasswordField;
	
	@FindBy (xpath = "//div[text()='Log In']")
	private WebElement logInButton;
	
	@FindBy (xpath = "//div[text()='Locations']")
	private WebElement locationButtonLink;
	
	public InstagramPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendTestData()
	{
		PhoneNumberUsernameOrEmailField.sendKeys("1236549875");
		PasswordField.sendKeys("qow55323311");
	}
	
	public void logIn()
	{
		logInButton.click();
	}
	
	public void location()
	{
		locationButtonLink.click();
	}
}
