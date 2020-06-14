package TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;

public class TestLoginPage extends BaseClass{
	LoginPage lp;
	HomePage hp;
	
	public ExtentReports report;
	public ExtentTest test;
	public TestLoginPage() {
		super();
	}

	@BeforeMethod
	public void SetUp()
	{
	report = new ExtentReports("C:\\Users\\Croma-PC\\workspace\\EndToEndAutomation\\src\\test\\resources\\reports");
	test = report.startTest("t1");
	initialization();
	lp = new LoginPage();
	hp = new HomePage();
	}
	
	@Test
	public void verifyLoginTest(String pwd)
	{
	test.log(LogStatus.PASS, "TestCase is passed");
	hp = lp.LoginPageTest(prop.getProperty(pwd));
	}
	
	
	@AfterMethod 
	public void teardown()
	{
		report.endTest(test);
		report.flush();
		driver.close();
		
	}
	

}
