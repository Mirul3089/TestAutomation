package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
	@FindBy(name = "username")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//span[@class='GSYpm']")
	public WebElement submit;

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement acceptcookies;

	public LoginPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public void Loginwithemail(String em, String pass) {
		// jse.executeScript("arguments[0].click();", acceptcookies);
		// acceptcookies.click();
		email.sendKeys(em);
		password.sendKeys(pass);
		jse.executeScript("arguments[0].click();", submit);
	}

	public void Loginwithoutemail(String em, String pass) {
		// jse.executeScript("arguments[0].click();", acceptcookies);
		// acceptcookies.click();
		email.sendKeys(em);
		password.sendKeys(pass);
		jse.executeScript("arguments[0].click();", submit);
	}

	public void Loginwithwrongemail(String em, String pass) {
		// jse.executeScript("arguments[0].click();", acceptcookies);
		// acceptcookies.click();
		email.sendKeys(em);
		password.sendKeys(pass);
		jse.executeScript("arguments[0].click();", submit);
	}

}
