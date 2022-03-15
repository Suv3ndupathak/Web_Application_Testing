package LoginStepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.LoggerHelper;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepD 
{
	WebDriver driver=null;
	HomePage home;
	LoginPage login;
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
	
	@When("Navigate to the login page")
	public void navigate_to_the_login_page() throws InterruptedException 
	{
		home=new HomePage(driver);
		login=new LoginPage(driver);
		home.clickOnLogin();
		login.pageName();
		login.Login();
		log.info("Clicking the login button");
	}

	@When("Enter the email {string} and {string}")
	public void enter_the_email_and(String email, String password) 
	{
		login.enterEmail(email);
		login.enterPassword(password);
		login.acceptCookie();
		log.info("Entering the login details");
	}

	@When("Click on SignIn button")
	public void click_on_SignIn_button() 
	{
		login.clickOnSignIn();
		log.info("Clicking on Sign in button");
	}

	@Then("Login must be successful")
	public void login_must_be_successful() 
	{
		login.getUrl();
		log.info("Checking the test is passed or not");
	}
	@After
	public void ExitBrowser()
	{
		driver.quit();
		log.info("=====Browser session has ended=====");
	}
}
