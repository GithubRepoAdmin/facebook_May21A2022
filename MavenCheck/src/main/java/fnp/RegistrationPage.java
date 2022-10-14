package fnp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	@FindBy (xpath = "//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedEnd']")
	private WebElement email;
	
	@FindBy (xpath = "//span[@class='cartButton_login_content__2j1f7']")
	private WebElement CONTINUEButton;
	
	public RegistrationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendInEmailField()
	{
		email.sendKeys("jamesbond007@gmail.com");
	}
	
	public void CONTINUEButton()
	{
		CONTINUEButton.click();
	}
	
	
	
}
