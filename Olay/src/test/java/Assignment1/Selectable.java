package Assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selectable 
{
	public WebDriver dr ; 
	 
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.get("https://demoqa.com/selectable/");
	}
	@Test
	public void SelectItems() throws InterruptedException
	{
		List<WebElement> Items=dr.findElements(By.className("ui-selectable"));
		for(WebElement webElement : Items)
		{
			webElement.click();
			Thread.sleep(2000);
			String name=webElement.getText();
			System.out.println(name);
			
		}
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}

}
