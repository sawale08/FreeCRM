package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[contains(@href, 'https://www.udemy.com')]")
	WebElement LaunchPageLoginBtn;
	
	@FindBy (xpath="//*[@id='udemy']/descendant::div[contains(@class, 'welcome-back')]//div")
	WebElement ConfirmUserName;
	
	@FindBy (css="input#id_password")
	WebElement password;
	
	@FindBy (css = "input#submit-id-submit")
	WebElement LoginBtnConfirm;
	
	public HomePage LoginPageTest(String pwd)
	{
		LaunchPageLoginBtn.click();
		ConfirmUserName.isDisplayed();
		password.sendKeys(prop.getProperty(pwd));
		LoginBtnConfirm.click();
		
		return new HomePage();
	}
}
