package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {     //POM class -> only WebElements & methods here
//  Declaration
//	Find all required webelements        webelements -> private & non-static

	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement messengerLink;
	
	@FindBy (xpath = "//a[text()='Instagram']")
	private WebElement instagramLink;
	
	
//	Initialization
//	constructor to initialize all webelements      // constructor -> public
	public HomePage(WebDriver driver)       
	{
		PageFactory.initElements(driver, this);    //initElements method finds all webElements one by one....sequence   FindBy -> locator -> stored in reference
	}
	
	
//	Use
//	methods to perform actions on webelements       // methods -> public, nonstatic and return type- void
	public void openMessenger()
	{
		messengerLink.click();
		
	}
	
	public void openInstagram()
	{
		instagramLink.click();
	}
	
	
	
	
}
