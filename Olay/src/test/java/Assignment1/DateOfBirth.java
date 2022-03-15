package Assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DateOfBirth 
{
	public WebDriver dr ;
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
	}
	@Test
	public void Execution() throws InterruptedException, ParseException
	{	
		
		dr.get("https://demoqa.com/datepicker/");
		dr.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		String setDatestr="06/12/1998";
	    String currDatestr=dr.findElement(By.className("ui-datepicker-title")).getText();
	    Date setDate =new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
	    Date currdate =new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
	    int monthDiff= Months.monthsBetween(new DateTime(currdate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();       
	    boolean isFuture=true;
	    if(monthDiff<0) 
	    {
	        isFuture=false;
	        monthDiff = -1 * monthDiff;
	    }
	    for (int i=0;i<monthDiff;i++)
	    {
	      if(isFuture)
	      dr.findElement(By.xpath("//span[text()='Next']")).click();
	      else
	      dr.findElement(By.xpath("//span[text()='Prev']")).click();
	      }
	    String day;
	    day=new SimpleDateFormat("dd").format(setDate);
	    dr.findElement(By.xpath("//a[text()='" + Integer.parseInt(day)+"']")).click();
	    Thread.sleep(2000);
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}

}
