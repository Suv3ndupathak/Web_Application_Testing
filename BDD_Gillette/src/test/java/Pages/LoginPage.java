package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	public String language;
	//France-Français
	//INDIA - ENGLISH
	//de - EUR
	@FindBy(xpath=" //*[@id=\"open_popin_country\"] | //*[@id=\"desk-country-selector\"]/div/a | //*[@id=\"nav\"]/div[2]/div[1]/div/div/button/span[1]/span ")
	WebElement PageName;
	
	@FindBy(xpath = "//*[@id=\"viewLoginForm\"]/a/strong")
	WebElement btn_France_Login;
	
	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_username\"] | //*[@id=\"email\"] | //*[@id=\"username\"]")
	WebElement txt_Email;
	
	@FindBy(xpath ="//*[@id=\"phdesktopbody_0_Container\"]/div[2]/input | //*[@id=\"passwd\"] | //*[@id=\"password\"]")
	WebElement txt_Password;
	
	@FindBy(id ="onetrust-accept-btn-handler")
	WebElement btn_Cookie;
	
	@FindBy(xpath ="//*[@id=\"phdesktopbody_0_Sign In\"] | //*[@id=\"SubmitLogin\"] | //*[@id=\"login-submit\"]")
	WebElement btn_SignIn;
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageName()
	{
		language=PageName.getText();
		System.out.println("Page language is= " +language);
	}
	
	public void Login() throws InterruptedException
	{
		try 
		{
			if (language.equals("France-Français")) 
			{
				btn_France_Login.click();
				Thread.sleep(2000);
			}
			else 
			{
				System.out.println("Extra login button is not there in this page");
			} 
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	public void enterEmail(String email)
	{
		try
		{
			txt_Email.sendKeys(email);
			System.out.println("Email has been entered......");
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	public void enterPassword(String password)
	{
		try
		{
			txt_Password.sendKeys(password);
			System.out.println("Password has been entered......");
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	public void acceptCookie()
	{
		try
		{
			if(language.equals("France-Français") || language.equals("de - EUR"))
			{
				btn_Cookie.click();
			}
			else
			{
				System.out.println("Cookie is not there in this page......");
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	public void clickOnSignIn()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(btn_SignIn));
			btn_SignIn.click();
			System.out.println("Sign in button has been clicked......");
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	
	public void getUrl()
	{
		try
		{
			String url = driver.getCurrentUrl();
			if (url.equals("https://www.gillette.co.in/en-in/viewprofilepage") || url.equals("https://www.gillette.fr/identite")|| url.equals("https://www.gillette.de/accountHome.account")) 
			{
				System.out.println("Test Passed......");
			} 
			else 
			{
				System.out.println("Test failed......");
			} 
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	
}
