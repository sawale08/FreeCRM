package TestPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;

public class TestHomePage extends BaseClass{
	LoginPage lp;
	HomePage hp;
	public TestHomePage() {
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		
	}
	
	@Test
	public void verifyTextTest()
	{
		Assert.assertTrue(hp.text());
	}

}
