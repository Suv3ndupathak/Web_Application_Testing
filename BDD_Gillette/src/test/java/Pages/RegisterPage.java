package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage
{
	public String language;
	//France-Français
	//INDIA - ENGLISH
	//de - EUR
	@FindBy(xpath=" //*[@id=\"open_popin_country\"] | //*[@id=\"desk-country-selector\"]/div/a | //*[@id=\"nav\"]/div[2]/div[1]/div/div/button/span[1]/span ")
	WebElement PageName;
	
	@FindBy(xpath = "//button[text()='Registrieren']")
	WebElement btn_Austria;
	
	@FindBy(id = "SubmitCreate")
	WebElement btn_France;
	
	@FindBy(id ="onetrust-accept-btn-handler")
	WebElement btn_Cookie;

	@FindBy(id = "customerName")
	WebElement txt_FullName;
	
	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_grs_consumer[firstname]\"] | //*[@id=\"customer_firstname\"]")
	WebElement txt_FirstName;

	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_grs_consumer[lastname]\"] | //*[@id=\"customer_lastname\"]")
	WebElement txt_LaststName;

	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_grs_account[emails][0][address]\"] | //*[@id=\"email\"] | //*[@id=\"customerEmail\"]")
	WebElement txt_Email;

	@FindBy(id = "confirmCustomerEmail")
	WebElement txt_ConfirmEmail;

	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_grs_account[password][password]\"] | //*[@id=\"passwd\"] | //*[@id=\"customerPassword\"]")
	WebElement txt_Password;

	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_grs_account[password][confirm]\"] | //*[@id=\"confirmPassword\"]")
	WebElement txt_ConfirmPassword;

	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][month]")
	WebElement drop_Month;

	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][year]")
	WebElement drop_Year;

	@FindBy(id = "phdesktopbody_0_grs_account[addresses][0][postalarea]")
	WebElement txt_postal;

	@FindBy(xpath="//*[@id=\"phdesktopbody_0_ctl44\"] | //*[@id=\"uniform-noThanks\"] | //*[@id=\"OptInReceiveNewsLetterRadio2\"]")
	WebElement checkBox;

	@FindBy(xpath = "//*[@id=\"phdesktopbody_0_submit\"] | //*[@id=\"submitAccount\"] | //*[@id=\"continue\"] ")
	WebElement txt_Submit;

	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageName()
	{
		language=PageName.getText();
		System.out.println("Page language is= " +language);
	}
	public void register()
	{
		if(language.equals("de - EUR"))
		{
			btn_Austria.click();
		}
		else if(language.equals("France-Français"))
		{
			btn_France.click();
		}
		else
		{
			System.out.println("Extra register button is not there in this page");
		}
	}
	public void acceptCookies()
	{
		try
		{
			if(language.equals("de - EUR"))
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(btn_Cookie));
				btn_Cookie.click();
				System.out.println("Cookie is accepted......");
				btn_Cookie.click();
			}
			else if(language.equals("France-Français"))
			{
				btn_Cookie.click();
				Thread.sleep(2000);
				System.out.println("Cookie is accepted......");
				btn_Cookie.click();
			}
			else
			{
				System.out.println("Cookie is not there in this website......");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("The Exception is=" +e.getMessage());
		}

	}
	public void enterFullName(String fullName)
	{
		try 
		{
			if (language.equals("de - EUR")) 
			{
				txt_FullName.sendKeys(fullName);
				System.out.println("Full name has been entered......");
			} 
			else
			{
				System.out.println("Full name field is not there for this website,,,,,,");
			}
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}	
	}
	public void enterFirstName(String firstName)
	{
		try 
		{	if(language.equals("INDIA - ENGLISH") || language.equals("France-Français") )
			{
				txt_FirstName.sendKeys(firstName);
				System.out.println("FirstName has been entered......");
			} 
			else
			{
				System.out.println("First name is not present in this website......");
			}
		}
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}	
	}
	public void enterLastName(String lastName)
	{
		try 
		{
			if(language.equals("INDIA - ENGLISH") || language.equals("France-Français"))
			{
				txt_LaststName.sendKeys(lastName);
				System.out.println("Last Name has been entered......");
			}
			else
			{
				System.out.println("Last name is not present in this website......");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
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
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void confirmEmail(String email)
	{
		try 
		{
			if (language.equals("de - EUR"))
			{
				txt_ConfirmEmail.sendKeys(email);
				System.out.println("Confirm Email has been entered...... ");
			} 
			else
			{
				System.out.println("Confirm email not present in this website......");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());		
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
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		try 
		{
			if (language.equals("INDIA - ENGLISH") || language.equals("de - EUR"))
			{
				txt_ConfirmPassword.sendKeys(confirmPassword);
				System.out.println("Confirm password has been entered......");
			}
			else
			{
				System.out.println("Confirm password not present in this website......");
			}
		} 
		catch (Exception e)
		{
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void month(String month)
	{
		try 
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				Select Month = new Select(drop_Month);
				Month.selectByVisibleText(month);
				System.out.println("Month has been selected......");
			} 
			else
			{
				System.out.println("Month is not present or optional in this website......");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void year(String year)
	{
		try 
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				Select Year = new Select(drop_Year);
				Year.selectByVisibleText(year);
				System.out.println("Year has been selected......");
			} 
			else
			{
				System.out.println("Year is not present or optional in this website......");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void postalNo(String zip)
	{
		try 
		{
			if(language.equals("INDIA - ENGLISH"))
			{
				txt_postal.sendKeys(zip);
				System.out.println("Postal code has been entered......");
			} 
			else
			{
				System.out.println("Postal code is not present or optional in this website......");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void checkbox()
	{
		try 
		{
			if (checkBox.isDisplayed()) 
			{
				checkBox.click();
			} 
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());
		}
	}
	public void submit()
	{
		try 
		{
			if (language.equals("INDIA - ENGLISH") || language.equals("de - EUR"))
			{
				txt_Submit.click();
				System.out.println("Submit button has been clicked......");
			}
			else if(language.equals("France-Français"))
			{
				Thread.sleep(150000);
				System.out.println("Submit button has been clicked......");
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is=" +e.getMessage());	
		}
	}
	public void getUrl()
	{
		try 
		{
			String url = driver.getCurrentUrl();
			if (url.equals("https://www.gillette.co.in/en-in/loginpage/create-profile-thank-you-page") || url.equals("https://www.gillette.fr/identite")|| url.equals("https://www.gillette.de/accountHome.account")) 
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
			System.out.println("The Exception is=" +e.getMessage());
		}
	}

}
