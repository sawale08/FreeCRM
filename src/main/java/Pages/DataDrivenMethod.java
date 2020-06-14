package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenMethod {
	

	private WebDriver driver;

	public DataDrivenMethod (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[contains(@href, 'https://www.udemy.com')]")
	WebElement LaunchPageLoginBtn;
	
	@FindBy (xpath="//*[@id='udemy']/descendant::div[contains(@class, 'welcome-back')]//div")
	boolean ConfirmUserName;
	
	@FindBy (css="input#id_password")
	WebElement password;
	
	@FindBy (css = "input#submit-id-submit")
	WebElement LoginBtnConfirm;

	public void verifyMultipleLogin (int TC, String username, String password)
	{
		LaunchPageLoginBtn.click();
		//ConfirmUserName
		password.sendKeys("");
		LoginBtnConfirm.click();
	}

}
