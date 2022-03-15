package StepDefinition;

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
import Pages.BookingPage;
import Pages.ReviewPage;
import Pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition 
{
	WebDriver driver=null;
	SearchPage search;
	BookingPage book;
	ReviewPage review;
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
		File src=new File("./src/test/resources/Configuration/config.property");
		FileInputStream fs=new FileInputStream(src);	
		Properties pro=new Properties();
		pro.load(fs);
		String Browser=pro.getProperty("BrowserName");
		String url=pro.getProperty("URL");
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

	@Given("Select one way trip with source and destination as {string} {string}")
	public void select_one_way_trip_with_source_and_destination_as(String from, String to) throws InterruptedException
	{
		search=new SearchPage(driver);
		search.onewaytrip(); 
		log.info("Selecting one way trip");
		search.source(from);
		log.info("Selecting source city");
	    search.destination(to);  
	    log.info("Selecting destination city");
	}

	@When("Select the departure date")
	public void select_the_departure_date() 
	{
		search.departureDate();
		log.info("Selecting departure date");
	}

	@When("Select the traveller details as {string} {string}")
	public void select_the_traveller_details_as(String adult, String child) 
	{
		search.travellersCount(adult, child);
		log.debug("Choosing the adult and child travellers number");
	}

	@Then("User should get an error regarding maximum traveller")
	public void user_should_get_an_error_regarding_maximum_traveller() 
	{
		search.getErrorMessage();
		log.error("Error message for choosing more than maximum travellers ");
	}

	@When("Select the departure date and traveller details as {string} {string}")
	public void select_the_departure_date_and_traveller_details_as(String adult, String child)
	{
		search.departureDate();
		log.info("Selecting departure date");
		search.travellersCount(adult, child);	
		log.debug("Choosing the adult and child travellers number");
	}

	@When("Search for the cheapest flight and book the flight")
	public void search_for_the_cheapest_flight_and_book_the_flight() 
	{
		book=new BookingPage(driver);
		search.searchCheapestFlight();
		log.info("Searching flight");
		book.bookNow();
		log.info("Booking ticket");
	}

	@Then("User should get all the details in the review page")
	public void user_should_get_all_the_details_in_the_review_page() 
	{
		review=new ReviewPage(driver);
		review.review();   
		log.info("Reviewing booking");
	}
	
	@After
	public void ExitBrowser()
	{
		driver.quit();
		log.info("=====Browser session has ended=====");
	}
}
