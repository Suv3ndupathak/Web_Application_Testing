package Assignment2;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OlayGermanyReg 
{
	public WebDriver dr ; 
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.get("https://www.olaz.de/de-de/");
		Thread.sleep(4000);
	}
	@Test
	public void Register() throws InterruptedException, BiffException, IOException
	{
		dr.findElement(By.id("onetrust-accept-btn-handler")).click();
		dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2]")).click();
		
		FileInputStream fs=new FileInputStream("Y:\\OLayGermany.xls");
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
			dr.findElement(By.id("phdesktopbody_0_imgmale")).click();
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[firstname]")).sendKeys(str[0]);
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[lastname]")).sendKeys(str[1]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[emails][0][address]")).sendKeys(str[2]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][password]")).sendKeys(str[3]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][confirm]")).sendKeys(str[4]);
			
			WebElement day_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][day]"));
			Select day=new Select(day_dropdown);
			day.selectByValue("05");
 
			WebElement month_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][month]"));
			Select month=new Select(month_dropdown);
			month.selectByValue("07");
			
			WebElement year_dropdown=dr.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][year]"));
			Select year=new Select(year_dropdown);
			year.selectByValue("1996");
			
			Thread.sleep(2000);
			
			WebElement Country_dropdown=dr.findElement(By.id("phdesktopbody_0_labelgrs_account[addresses][0][country]"));
			Select country=new Select(Country_dropdown);
			country.selectByValue("DEU");
			
			dr.findElement(By.id("phdesktopbody_0_labelgrs_account[addresses][0][country]")).click();
			dr.findElement(By.xpath("//*[@id=\"phdesktopbody_0_labelgrs_account[addresses][0][country]\"]/option[2]")).click();

			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_labelgrs_account[addresses][0][line1]")).sendKeys(str[5]);

			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_account[addresses][0][postalarea]")).sendKeys(str[6]);

			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_labelgrs_account[addresses][0][city]")).sendKeys(str[7]);

			dr.findElement(By.id("phdesktopbody_0_submit")).click();
			
			Thread.sleep(3000);
			dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2]")).click();
			

		}
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}
}
