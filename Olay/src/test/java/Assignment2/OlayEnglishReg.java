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

public class OlayEnglishReg 
{
	public WebDriver dr ; 
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.get("https://www.olay.co.uk/en-gb");
	}
	@Test
	public void RegistrationDetails() throws InterruptedException, BiffException, IOException
	{
		//Clicking on Register button
		dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2]")).click();
		Thread.sleep(4000);
		//Handling the advertisements
		dr.findElement(By.id("onetrust-reject-all-handler")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"skinAdvisor-banner\"]/span[1]/img")).click();
		//Fetching details from Excel file
		FileInputStream fs=new FileInputStream("Y:\\OlayEnglish.xls");
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
			//Entering Email
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]")).sendKeys(str[0]);
			//Entering Passwords
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][password]")).sendKeys(str[1]);
			
			dr.findElement(By.id("phdesktopbody_0_grs_account[password][confirm]")).sendKeys(str[2]);
			//Selecting Date
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][day]")).click();
			dr.findElement(By.xpath("//*[@id=\"phdesktopbody_0_grs_consumer[birthdate][day]\"]/option[4]")).click();
			//Selecting Month
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]")).click();
			dr.findElement(By.xpath("//*[@id=\"phdesktopbody_0_grs_consumer[birthdate][month]\"]/option[5]")).click();
			//Selecting Year
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][year]")).click();
			dr.findElement(By.xpath("//*[@id=\"phdesktopbody_0_grs_consumer[birthdate][year]\"]/option[20]")).click();
			//Submitting the form
			dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_submit")).click();
			Thread.sleep(3000);
			//Entering Subscription Data
			dr.findElement(By.name("phdesktopbody_1$phdesktopbody_0_grs_consumer[firstname]")).sendKeys(str[3]);
			dr.findElement(By.name("phdesktopbody_1$phdesktopbody_0_grs_consumer[lastname]")).sendKeys(str[4]);
			dr.findElement(By.id("phdesktopbody_0_labelgrs_account[addresses][0][line1]")).sendKeys(str[5]);
			dr.findElement(By.id("phdesktopbody_0_labelgrs_account[addresses][0][city]")).sendKeys(str[6]);
			dr.findElement(By.id("phdesktopbody_0_grs_account[addresses][0][postalarea]")).sendKeys(str[7]);
			//Submit
			dr.findElement(By.id("phdesktopbody_0_SubmitBtn")).click();
			Thread.sleep(2000);
			//Printing the registration successful message  
			System.out.println(dr.findElement(By.id("phdesktopbody_0_Header")).getText());
			dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2]")).click();
			Thread.sleep(4000);
			
		}
		
	}
	@AfterTest
	public void ExitBrowser()
	{
		dr.close();
	}
}
