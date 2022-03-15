package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage 
{
	public String language;
	//France-Français
	//INDIA - ENGLISH
	//de - EUR
	@FindBy(xpath=" //*[@id=\"open_popin_country\"] | //*[@id=\"desk-country-selector\"]/div/a | //*[@id=\"nav\"]/div[2]/div[1]/div/div/button/span[1]/span ")
	WebElement PageLanguage;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/div[6]/div/div[3]/div/a/p | //*[@id=\"phdesktopbody_0_HlinkEdit\"]")
	WebElement btn_Edit;
	
	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_HlinkReset\"]")
	WebElement btn_ResetPasswd;
	
	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_username\"]")
	WebElement txt_Email;
	
	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_Create Your New Password\"]")
	WebElement btn_Save;
	
	@FindBy(xpath = "//*[@id=\"old_passwd\"] | //*[@id=\"oldPassword\"]")
	WebElement txt_OldPasswd;
	
	@FindBy(xpath = "//*[@id=\"passwd\"] | //*[@id=\"newPassword\"]")
	WebElement txt_NewPasswd;
	
	@FindBy(xpath = "//*[@id=\"confirmation\"]| //*[@id=\"confirmPassword\"]")
	WebElement txt_ConfirmPasswd;
	
	@FindBy(xpath = "//*[@id=\"identity_page\"]/div/form/div[9]/button | //*[@id=\"accountSettingsForm\"]/fieldset/button")
	WebElement btn_Submit;
	
	@FindBy(xpath= "//*[@id=\\\"identity_page\\\"]/div/p")
	WebElement msg_Success;
	
	WebDriver driver;
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageName()
	{
		language=PageLanguage.getText();
		System.out.println("Page language is= " +language);
	}
	public void clickOnEdit()
	{
		try
		{
			if(language.equals("INDIA - ENGLISH") || language.equals("de - EUR"))
			{
				btn_Edit.click();
				System.out.println("Edit profile button has been clicked......");
			}
			else
			{
				System.out.println("Edit button is not there in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void clickOnResetPassword()
	{
		try
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				btn_ResetPasswd.click();
				System.out.println("Reset password button has been clicked......");
			}
			else
			{
				System.out.println("Reset password button is not present in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void enterEmail(String email)
	{
		try
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				txt_Email.sendKeys(email);
				System.out.println("Email has been entered......");
			}
			else
			{
				System.out.println("Email field is not there in this page......");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void clickOnSave()
	{
		try
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				btn_Save.click();
				System.out.println("Save button has been clicked......");
			}
			else
			{
				System.out.println("Save button is not there in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void enterOldPassword(String oldPassword)
	{
		try
		{
			if(language.equals("France-Français") || language.equals("de - EUR"))
			{
				txt_OldPasswd.sendKeys(oldPassword);
				System.out.println("Old password has been entered......");
			}
			else
			{
				System.out.println("Old password field is not there in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void enterNewPasword(String newPassword)
	{
		try
		{
			if(language.equals("France-Français") || language.equals("de - EUR"))
			{
				txt_NewPasswd.sendKeys(newPassword);
				System.out.println("New password has been entered......");
			}
			else
			{
				System.out.println("New password field is not there in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		try
		{
			if(language.equals("France-Français") || language.equals("de - EUR"))
			{
				txt_ConfirmPasswd.sendKeys(confirmPassword);
				System.out.println("Confirm password has been entered......");
			}
			else
			{
				System.out.println("Confirm password field is not there in this page......");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void clickOnsubmit()
	{
		try
		{
			if(language.equals("France-Français") || language.equals("de - EUR"))
			{
				btn_Submit.click();
				System.out.println("Submit button has been clicked......");
			}
			else
			{
				System.out.println("Submit button is not there......");
			}
		
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
	public void result()
	{
		try
		{
				String url = driver.getCurrentUrl();
				if(url.equals("https://www.gillette.de/accountHome.account")|| url.equals("https://www.gillette.co.in/en-in/forgot-password") || url.equals("https://www.gillette.fr/identite"))
				{
					System.out.println("Test passed......");
				}
				else
				{
					System.out.println("Test failed......");
				}
		}
		catch(Exception e)
		{
			System.out.println("The Exception is= " +e.getMessage());
		}
	}
}
