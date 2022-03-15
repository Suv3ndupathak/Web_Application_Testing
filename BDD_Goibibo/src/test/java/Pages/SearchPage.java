package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.LoggerHelper;

public class SearchPage 
{
	String MonthToBeSelected = "August 2020";
	
	@FindBy(id = "roundTrip")
	WebElement btn_round;

	@FindBy(id = "oneway")
	WebElement btn_oneway;

	@FindBy(id = "gosuggest_inputSrc")
	WebElement txt_from;

	@FindBy(id = "gosuggest_inputDest")
	WebElement txt_to;

	@FindBy(xpath = "//div[@class='DayPicker-Caption' and @role='heading']")
	WebElement btn_pagedate;
	
	@FindBy(xpath = "//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement btn_nextmonth;
	
	@FindBy(xpath = "//div[text()='15']")
	WebElement btn_day;

	@FindBy(id = "pax_label")
	WebElement btn_traveller;

	@FindBy(id = "adultPaxBox")
	WebElement txt_adult;

	@FindBy(id = "childPaxBox")
	WebElement txt_child;

	@FindBy(id = "pax_close")
	WebElement btn_close;

	@FindBy(className = "status_cont")
	WebElement btn_text;

	@FindBy(id = "gi_search_btn")
	WebElement btn_searchflight;

	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void onewaytrip()
	{
		try 
		{
			btn_round.click();
			btn_oneway.click();
			System.out.println("One way flight has been selected......");
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());
		}	
	}
	public void source(String from) throws InterruptedException
	{
		try
		{
			txt_from.sendKeys(from);
			Thread.sleep(3000);
			txt_from.sendKeys(Keys.ARROW_DOWN);
			txt_from.sendKeys(Keys.ENTER);
			System.out.println("From city name has been entered......");
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
	}
	public void destination(String to) throws InterruptedException 
	{
		try
		{
			txt_to.sendKeys(to);
			Thread.sleep(3000);
			txt_to.sendKeys(Keys.ARROW_DOWN);
			txt_to.sendKeys(Keys.ENTER);
			System.out.println("To city name has been entered......");
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
		
	}
	public void departureDate()
	{
		try
		{
			String text = btn_pagedate.getText();
			while (true)
			{
				if (text.equalsIgnoreCase(MonthToBeSelected)) 
				{
					break;
				}
				else 
				{
					btn_nextmonth.click();
				}
				btn_day.click();
				System.out.println("Choosing the departure date......");
			} 
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());	
		}		
	}
	public void travellersCount(String adult, String child)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(btn_traveller));
			btn_traveller.click();
			System.out.println("Travellers button has been clicked......");
			txt_adult.clear();
			System.out.println("Entering the number of adult travellers......");
			txt_adult.sendKeys(adult);
			txt_child.clear();
			txt_child.sendKeys(child);
			System.out.println("Entering the number of child travellers......");
			btn_close.click();
			System.out.println("Clicking the close sign......");
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());
		}

	}
	public void getErrorMessage()
	{
		try
		{
			String ErrMsg=btn_text.getText();
			if(ErrMsg.equals("Maximum of 9 travellers allowed"))
			{
				System.out.println("Test passed......");
			}
			else
			{
				System.out.println("Test failed......");
			}
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
	}
	public void searchCheapestFlight()
	{
		try
		{
			btn_searchflight.click();
			System.out.println("Search button has been clicked......");
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
	}
}
