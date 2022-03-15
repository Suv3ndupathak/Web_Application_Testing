package Assignment2;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OlayGermanyLogin 
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
	public void Login() throws BiffException, IOException
	{
		dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[1]/font/font")).click();
		FileInputStream fs=new FileInputStream("Y:\\OLayGermany.xls");
		Workbook w=Workbook.getWorkbook(fs);
		Sheet s=w.getSheet(1);
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
			dr.findElement(By.id("phdesktopbody_0_username")).sendKeys(str[0]);
			dr.findElement(By.id("phdesktopbody_0_password")).sendKeys(str[1]);
			dr.findElement(By.id("phdesktopbody_0_ANMELDEN")).click();
		}
		
	}
	@AfterTest
	public void ExitBrowse()
	{
		dr.close();
	}
}
