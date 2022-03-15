package RegStepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.LoggerHelper;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepD 
{
	WebDriver driver=null;
	RegisterPage reg;
	HomePage home;
	Logger log=LoggerHelper.getLogger(LoggerHelper.class);
	@Before
	public void before()
	{
		log.info("=====Browser session has started=====");
		System.out.println("Choosing the driver......");
	}
	@Given("Open the browser and launch the application")
	public void open_the_browser_and_launch_the_application() throws IOException 
	{
		File src=new File("./src/test/resources/Configuration/configure.property");
		FileInputStream fs=new FileInputStream(src);	
		Properties pro=new Properties();
		pro.load(fs);
		String Browser=pro.getProperty("BrowserName");
		String url=pro.getProperty("URL1");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Launching the chrome driver.......");
			System.setProperty("webdriver.chrome.driver", "/home/suvendu/Downloads/Softwares/chromedriver_linux64/chromedriver");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			log.info("=====Application started=====");

		}
		else if(Browser.equalsIgnoreCase("firefox")) 
		{
			//code to launch Firefox
			System.out.println("Launching the firefox driver.......");
			System.setProperty("webdriver.gecko.driver", "/home/suvendu/Downloads/Softwares/geckodriver-v0.26.0-linux64/geckodriver");
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			log.info("=====Application started=====");
		}
	}

	@When("Navigate to the registration page")
	public void navigate_to_the_registration_page()
	{
		reg=new RegisterPage(driver);
		home=new HomePage(driver);
		home.clickOnRegister();
		reg.pageName();
		log.info("Clicking on register button");
		reg.acceptCookies();
		log.info("Cookie is being accepted");
	}

	@When("Enter the registration details as {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_the_registration_details_as(String fullName, String firstName, String lastName, String email, String password, 
			String confirmPassword, String month, String year, String zip) 
	{
		log.info("Entering registration details");
		reg.register();
		reg.enterFullName(fullName);
		reg.enterFirstName(firstName);
		reg.enterLastName(lastName);
		reg.enterEmail(email);
		reg.confirmEmail(email);
		reg.enterPassword(password);
		reg.enterConfirmPassword(confirmPassword);
		reg.month(month);
		reg.year(year);
		reg.postalNo(zip);
		reg.checkbox();
	
	}

	@When("Click on submit")
	public void click_on_submit()
	{
		log.info("Clicking on submit button");
	    reg.submit();
	}

	@Then("User should be able to register successfully")
	public void user_should_be_able_to_register_successfully() 
	{
		log.debug("Checking the test is passed or not");
	    reg.getUrl();
	}
	@After
	public void ExitBrowser()
	{
		driver.quit();
		log.info("=====Browser session has ended=====");
	}
}
