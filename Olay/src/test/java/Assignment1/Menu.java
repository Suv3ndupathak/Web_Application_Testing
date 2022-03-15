package Assignment1;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Menu 
{
	public WebDriver dr ;
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.get("https://demoqa.com/selectmenu/");	
	 }
	@Test(priority=0)
	public void Speed() throws ParseException, InterruptedException
	{
		dr.findElement(By.id("speed-button")).click();
		dr.findElement(By.xpath("//div[text()='Fast']")).click();	
	}
	@Test(priority=1)
	public void file()
	{
		dr.findElement(By.id("files-button")).click();
		dr.findElement(By.xpath("//div[text()='Some unknown file']")).click();
	}
	@Test(priority=2)
	public void Number()
	{
		dr.findElement(By.id("number-button")).click();
		dr.findElement(By.xpath("//div[text()='5']")).click();
	}
	@Test(priority=3)
	public void Title()
	{
		dr.findElement(By.id("salutation-button")).click();
		dr.findElement(By.id("//div[text()='Mr.']")).click();
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}
}
