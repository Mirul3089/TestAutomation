package selenium;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;

	public LoginPageTest() throws FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization(); // Initialize web drivers
		try {
			lp = new LoginPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// test cases should be independent and separated
	@Test
	public void verifytitletext() {
		String actualtext = driver.getTitle();
		Assert.assertEquals(actualtext, "Best Buy");
	}

	@Test
	public void loginwithemail() {
		lp.Loginwithemail(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void loginwithoutemail() {
		lp.Loginwithoutemail(prop.getProperty("bemail"), prop.getProperty("password"));
	}

	@Test
	public void loginwithwrongemail() {
		lp.Loginwithwrongemail(prop.getProperty("wemail"), prop.getProperty("password"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
