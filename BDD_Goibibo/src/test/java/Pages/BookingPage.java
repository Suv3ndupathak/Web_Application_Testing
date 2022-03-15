package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage 
{
	@FindAll(@FindBy(how = How.CSS, using = "input[type='button']"))
	List<WebElement> btn_bookNow;
	
	WebDriver driver;
	public BookingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void bookNow()
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfAllElements(btn_bookNow));
			btn_bookNow.get(0).click();
			System.out.println("Cheapest flight has been booked......");
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
	}
}
