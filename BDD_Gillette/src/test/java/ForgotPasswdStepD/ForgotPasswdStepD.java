package ForgotPasswdStepD;

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
import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswdStepD 
{
	WebDriver driver=null;
	HomePage home;
	LoginPage login;
	ForgotPasswordPage forgotPasswd;
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

	@When("Navigate to the login page and click on forgot password button")
	public void navigate_to_the_login_page_and_click_on_forgot_password_button() throws InterruptedException 
	{
		home=new HomePage(driver);
		login=new LoginPage(driver);
		forgotPasswd=new ForgotPasswordPage(driver);
		home.clickOnLogin();
		forgotPasswd.pageName();
		forgotPasswd.acceptCookies();
		forgotPasswd.FranceLogin();
		forgotPasswd.clickOnForgotPasswd();
	}

	@When("Enter the email {string} and click on submit button")
	public void enter_the_email_and_click_on_submit_button(String email) 
	{
		forgotPasswd.enterEmail(email);
		log.info("Entering email");
		forgotPasswd.clickOnSubmit();
		log.info("Clicking on submit button");
	}

	@Then("User should be navigated to the thank you page")
	public void user_should_be_navigated_to_the_thank_you_page() 
	{
		forgotPasswd.checkSuccessMessage();
		log.info("Checking the test is passed of failed");
	}
	@After
	public void ExitBrowser()
	{
		driver.quit();
		log.info("=====Browser session has ended=====");
	}

}
