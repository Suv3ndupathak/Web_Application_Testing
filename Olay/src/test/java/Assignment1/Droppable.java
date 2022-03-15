package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Droppable 
{
	public WebDriver dr ; 
	@BeforeTest
	public void LaunchBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.get("https://demoqa.com/droppable/");
	}
	@Test
	public void Actions()
	{
		WebElement From=dr.findElement(By.xpath("//*[@id=\"draggable\"]"));	
        //Element on which need to drop		
        WebElement To=dr.findElement(By.xpath("//*[@id=\"droppable\"]"));					
        //Using Action class for drag and drop		
        Actions act=new Actions(dr);					
        //Dragged and dropped	
        act.dragAndDrop(From, To).build().perform();	
        WebElement msg=dr.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        String text=msg.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(text,expectedText);
		System.out.println("Done");
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}
	
}
