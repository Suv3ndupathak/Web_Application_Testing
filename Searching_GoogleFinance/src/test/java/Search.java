import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {

	public static void main(String[] args)
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Suvendu Pathak\\GitHub\\LoginPage_DataProvider\\Driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			driver.manage().window().maximize();
			driver.get("https://www.google.com/finance/");
			System.out.println("Google finance page opened.....");
			driver.findElement(By.xpath("//*[text()='Crypto']")).click();
			System.out.println("Clicking on Crypto button.....");
			WebElement Ether=driver.findElement(By.xpath("//*[text()='Ether (ETH / INR)']"));
			String text=Ether.getText();
			System.out.println(text);
			Ether.click();
			System.out.println("Searching for Ethereum coin.....");
			driver.quit();
		}
		catch (Exception e) 
		{
			System.out.println("Exception is=" +e.getMessage());
		}		





	}

}
