package ResetPasswdStepD;

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
import Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPasswdStepD 
{
	WebDriver driver=null;
	HomePage home;
	LoginPage login;
	ResetPasswordPage reset;
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

	@When("Enter the email {string} and {string} and click on SignIn")
	public void enter_the_email_and_and_click_on_SignIn(String email, String password) throws InterruptedException 
	{
		home=new HomePage(driver);
		login=new LoginPage(driver);
		home.clickOnLogin();
		login.pageName();
		login.Login();
		log.info("Clicking the login button");
		login.enterEmail(email);
		login.enterPassword(password);
		login.acceptCookie();
		log.info("Entering the login details");
		login.clickOnSignIn();
		log.info("Clicking on Sign in button");
	}


	@When("Click on edit button and enter {string} or {string} {string} {string}")
	public void click_on_edit_button_and_enter_or(String email, String oldPassword, String newPassword, String confirmPassword) 
	{
		reset=new ResetPasswordPage(driver);
		reset.pageName();
		reset.clickOnEdit();
		reset.clickOnResetPassword();
		log.info("Clicking on reset paswsword button");
		reset.enterEmail(email);
		log.info("Entering email");
		reset.clickOnSave();
		reset.enterOldPassword(oldPassword);
		log.info("Entering old password");
		reset.enterNewPasword(newPassword);
		log.info("Entering new password");
		reset.enterConfirmPassword(confirmPassword);
		log.info("Entering confirm password");
	  
	}

	@When("click on submit button")
	public void click_on_submit_button() 
	{
		reset.clickOnsubmit();
		log.info("Clicking on submit");
	}

	@Then("User should be navigated to the thank you page")
	public void user_should_be_navigated_to_the_thank_you_page() 
	{
	    reset.result();
	    log.info("Checking the test is passed or not");
	}
	@After
	public void ExitBrowser()
	{
		driver.quit();
		log.info("=====Browser session has ended=====");
	}
}
