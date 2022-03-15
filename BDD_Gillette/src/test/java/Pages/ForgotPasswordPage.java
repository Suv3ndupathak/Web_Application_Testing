package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage 
{
	public String language;

	@FindBy(xpath=" //*[@id=\"open_popin_country\"] | //*[@id=\"desk-country-selector\"]/div/a | //*[@id=\"nav\"]/div[2]/div[1]/div/div/button/span[1]/span ")
	WebElement PageName;
	
	@FindBy(id ="onetrust-accept-btn-handler")
	WebElement btn_Cookie;	
	
	@FindBy(xpath = "//*[@id=\"viewLoginForm\"]/a/strong")
	WebElement btn_France_Login;
	
	@FindBy(xpath="//*[@id=\"phdesktopbody_0_forgotpassword\"] | //*[@id=\"login-form\"]/div/div/div/button | //*[@id=\"login_form\"]/div[2]/p[1]/a")
	WebElement btn_ForgotPasswd;
	
	@FindBy(xpath="//*[@id=\"email\"] | //*[@id=\"forgotten-password-email-field\"] | //*[@id=\"phdesktopbody_0_username\"]")
	WebElement txt_Email;
	
	@FindBy(xpath="//*[@id=\"form_forgotpassword\"]/p[2]/button | /html/body/div[5]/div/div/section[1]/form/input[4] | //*[@id=\"phdesktopbody_0_Create Your New Password\"]")
	WebElement btn_Save;
	
	@FindBy(xpath="//*[@id=\"form_forgotpassword\"]/p | //*[@id=\"phdesktopbody_0_afterSubmit\"]/div[2]/h2 | /html/body/div[5]/div/div/section[2]/p")
	WebElement msg_success;

	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageName()
	{
		language=PageName.getText();
		System.out.println("Page language is= " +language);
	}
	
	public void acceptCookies() throws InterruptedException
	{
		if(language.equals("France-Français"))
		{
			btn_Cookie.click();
			Thread.sleep(2000);
			btn_Cookie.click();
			System.out.println("Accepting cookies......");
		}
		else if(language.equals("de - EUR"))
		{
			btn_Cookie.click();
			System.out.println("Accepting cookies......");
		}
		
	}
	
	public void FranceLogin() throws InterruptedException
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
	
	
	public void clickOnForgotPasswd()
	{
		try
		{
			btn_ForgotPasswd.click();
			System.out.println("Forgot password button has been clicked......");
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
	
	public void clickOnSubmit()
	{
		try
		{
			if (language.equals("France-Français") || language.equals("INDIA - ENGLISH"))
			{
				btn_Save.click();
				System.out.println("Submit button has been clicked......");
			}
			else if(language.equals("de - EUR"))
			{
				btn_Save.click();
				Thread.sleep(2000);
				System.out.println("Submit button has been clicked......");
			}	
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is =" +e.getMessage());
		}
	}
	
	public void checkSuccessMessage()
	{
		try
		{
			String text=msg_success.getText();
			if(text.equals("Si le compte d'utilisateur existe, un email de confirmation a été envoyé à cette adresse e-mail.") || text.equals("You will receive an e-mail very shortly containing a link to reset your password.")
					|| text.equals("Anweisung zur Zurücksetzung deines Passwortes wurden an die folgende Adresse gesendet\n" + 
							"suv08@gmail.com"))
			{
				System.out.println("Test passed......");	
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
