package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RentalCarBlock 
{
	public WebDriver dr ;
	@BeforeTest
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.get("https://demoqa.com/controlgroup/");	
	}
	@Test
	public void Action1() throws InterruptedException
	{
		dr.findElement(By.id("car-type-button")).click();
		dr.findElement(By.id("ui-id-4")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[1]/div/label[1]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[1]/div/label[3]/span[2]")).click();
		dr.findElement(By.id("horizontal-spinner")).sendKeys("4");
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[1]/div/button")).click();
		Thread.sleep(4000);
	
	}
	@Test
	public void Action2() throws InterruptedException
	{
		dr.findElement(By.id("ui-id-8-button")).click();
		dr.findElement(By.id("ui-id-14")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[2]/div/label[2]")).click();;
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[2]/div/label[3]")).click();;
		dr.findElement(By.id("vertical-spinner")).sendKeys("3");
		dr.findElement(By.id("book")).click();
		Thread.sleep(4000);
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}
}
