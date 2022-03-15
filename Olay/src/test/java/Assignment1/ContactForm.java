package Assignment1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ContactForm 
{
	public WebDriver dr ; 

	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox"))
		{
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			dr = new FirefoxDriver();
			dr.manage().window().maximize();
			dr.manage().deleteAllCookies();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.manage().deleteAllCookies();
		}
		else
		{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void LaunchBrowser()
	{
		dr.get("https://demoqa.com/html-contact-form/");
	}
	@Test(priority=2)
	public void EnterDetails() throws BiffException, IOException, InterruptedException
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\Suvendu Pathak\\Documents\\Book2.xls");
		Workbook w=Workbook.getWorkbook(fs);
		Sheet s=w.getSheet(0);
		//Fetching FirstName from Excel
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/input[1]")).sendKeys(s.getCell(0,1).getContents());
		//Fetching LastName from Excel
		dr.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(s.getCell(1,1).getContents());
		//Fetching Country from Excel
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/input[3]")).sendKeys(s.getCell(2,1).getContents());
		//Clicking the partial link text
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		dr.findElement(By.partialLinkText("Google Link")).sendKeys(selectLinkOpeninNewTab);
		Thread.sleep(2000);
		//Clicking the partial link text
		dr.findElement(By.partialLinkText("Link is here")).sendKeys(selectLinkOpeninNewTab);
		Thread.sleep(2000);
		// Entering the subject from Excel
		dr.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(s.getCell(3,1).getContents());
		Thread.sleep(2000);
		//licking the submit button
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/input[4]")).click();
	}
	@AfterTest
	public void ExitDriver()
	{
		dr.quit();
	}
}
