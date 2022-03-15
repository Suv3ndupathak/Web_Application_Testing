package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	@FindBy(xpath ="//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[2] | //*[@id=\"user_link\"]/li[1]/a | //*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/div[1]/a")
	WebElement btn_register;
	
	@FindBy(xpath = "//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[1] | //*[@id=\"user_link\"]/li[1]/a | //*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/div[1]/a")
	WebElement btn_login;
	
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRegister()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btn_register));
		btn_register.click();	
		System.out.println("Register button has been clicked");
	}
	public void clickOnLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btn_login));
		btn_login.click();
		System.out.println("Login button has been clicked");
	}
	
}
