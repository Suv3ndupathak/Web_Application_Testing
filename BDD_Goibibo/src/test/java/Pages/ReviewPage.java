package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage 
{
	@FindBy(xpath = "//a[text()='Baggage and Fare Rules']")
	WebElement txt_rule;

	@FindBy(xpath = "//span[text()='CCU-MAA']")
	WebElement txt_Text;


	WebDriver driver;
	public ReviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void review()
	{
		try
		{
			for(String winHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
			}
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(txt_rule));
			txt_rule.click();
			System.out.println("Checking the flight rules......");
			String msg=txt_Text.getText();
			if(msg.equals("CCU-MAA"))
			{
				System.out.println("Test Passed......");
			}
			else
			{
				System.out.println("Review is not done......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= "+e.getMessage());
		}
	}
}