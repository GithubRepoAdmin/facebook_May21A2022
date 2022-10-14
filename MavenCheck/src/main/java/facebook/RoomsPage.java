package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {

	@FindBy (xpath = "//a[text()=' Return to messenger.com ']")
	private WebElement returnToMessengerButton;
	
	@FindBy (xpath = "//a[text()=' Visit our help center ']")
	private WebElement visitOurHelpCenterButton;
	
	public RoomsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void returnToMessenger()
	{
		returnToMessengerButton.click();
	}
	
	public void visitOurHelpCenter()
	{
		visitOurHelpCenterButton.click();
	}
}
