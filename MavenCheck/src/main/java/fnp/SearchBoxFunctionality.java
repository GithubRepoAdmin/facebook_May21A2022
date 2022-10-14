package fnp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBoxFunctionality {
	
	
		@FindBy (xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root jss13']")
		private WebElement closePop;
		
		@FindBy (xpath = "//input[@id='header-search-input']")
		private WebElement search;
		
		@FindBy (xpath = "//button[@class='header-search_search-button__1PbwC']")
		private WebElement magniGlass;
		
		
		public SearchBoxFunctionality (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void closePopup()
		{
			closePop.click();
		}
		
		public void sendInsearchBox()
		{
			search.sendKeys("Flowers");
		}
		
		public void clickOnSearch()
		{
			search.click();
		}
		
		public void clickOnmagnifyingGlass()
		{
			magniGlass.click();
		}
			
		// Total functionality
//		public void searchFunctionality()
//		{
//			closePop.click();
//			search.sendKeys("personalised cusion");
//			search.click();
//			magniGlass.click();
//		}
		
	

	
}
	



