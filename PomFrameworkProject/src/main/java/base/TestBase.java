package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.TestUtils;
import utils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws FileNotFoundException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream(
				"E:\\QA\\Selenium_WorkSpace\\PomFrameworkProject\\src\\main\\java\\config\\config.properties");
		try {
			prop.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() throws FileNotFoundException {
		String browser = prop.getProperty("browser");
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\QA\\Material\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\QA\\Material\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new SafariDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}
}
