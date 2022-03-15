package Assignment2;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OlaySpainReg 
{
	public WebDriver dr ; 
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.get("https://www.olay.es/es-es");
		Thread.sleep(3000);
		dr.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(2000);
		
	}
	@Test
	public void Register() throws BiffException, IOException, InterruptedException
	{
		FileInputStream fs=new FileInputStream("Y:\\OlaySpain.xls");
		Workbook w=Workbook.getWorkbook(fs);
		Sheet s=w.getSheet(0);
		int r=s.getRows();
		int c=s.getColumns();
		System.out.println("No of rows"+r);
		System.out.println("No of comumns"+c);
		String str[]=new String[c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				Cell c1=s.getCell(j, i);
				str[j]=c1.getContents();
				System.out.println(str[j]);
				
			}
			dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2]")).click();
			Thread.sleep(4000);
			dr.findElement(By.id("phdesktopbody_0_imgmale")).click();
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[firstname]")).sendKeys(str[0]);
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[lastname]")).sendKeys(str[1]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[emails][0][address]")).sendKeys(str[2]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][password]")).sendKeys(str[3]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][confirm]")).sendKeys(str[4]);
			
			WebElement day_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][day]"));
			Select day=new Select(day_dropdown);
			day.selectByValue("06");
 
			WebElement month_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][month]"));
			Select month=new Select(month_dropdown);
			month.selectByValue("09");
			
			WebElement year_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][year]"));
			Select year=new Select(year_dropdown);
			year.selectByValue("1990");
			Thread.sleep(2000);
		    dr.findElement(By.id("phdesktopbody_0_grs_account[phones][0][fulltelephonenumber]")).sendKeys("+34910600484");
		    Thread.sleep(2000);
			WebElement option1 = dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_ctl74"));							

		        // This will Toggle the Check box 		
		    option1.click();
		   
		    Thread.sleep(2000);
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_submit")).click();
		}	
	}

}
