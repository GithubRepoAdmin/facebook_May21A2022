package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {

	@FindBy (xpath = "//a[text()='Rooms']")
	private WebElement roomsButton;
	
	@FindBy (xpath = "//a[text()='Features']")
	private WebElement featuresButton;
	
	public MessengerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openRooms() 
	{
		roomsButton.click();
	}
	
	public void openFeatures() 
	{
		featuresButton.click();
	}
	
}
