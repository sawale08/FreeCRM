package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[contains(@class, 'my-learning-unit--header-container')]/h2")
	WebElement verifyText;
	
	
	public boolean text()
	{
		return verifyText.isDisplayed();
	}

}
