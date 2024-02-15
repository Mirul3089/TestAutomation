package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
	}

	@When("title of login page is {string}")
	public void title_of_login_page_is(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}

	@Then("user enters invalid credentials {string} and {string}")
	public void user_enters_invalid_credentials_and(String username, String pass) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("uapPassword")).sendKeys(pass);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@class='btn btn-block td-button-secondary']")).click();
	}

//	@Then("user get error for email")
//	public void user_get_error_for_email() {
//		String actualError = driver.findElement(By.xpath("//span[@id='error']")).getText();
//		String expectederror = "Sorry, your login entry doesn't match our records. Please try again.";
//		Assert.assertEquals(expectederror, actualError);
//	}

	@Then("user quit")
	public void user_quit() {
		driver.quit();
	}
}
