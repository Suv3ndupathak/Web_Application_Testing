package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OlayEngPasswdChngResetPasswd 
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
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[1]")).click();
		Thread.sleep(4000);
		dr.findElement(By.id("onetrust-reject-all-handler")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"skinAdvisor-banner\"]/span[1]/img")).click();
	}
	@Test(priority=2)
	public void Case1() throws InterruptedException
	{
		//CASE- 1. Both User name and Password are entered correctly. 
		
		//Check whether Email field exists or not 
		 try
	        {
	          WebElement a1 = dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_username"));
	          System.out.println("Username exists -----");
	          a1.sendKeys("suy759@gmail.com");
	         }
	    catch(Throwable e)
	         {
	         System.out.println("UserName not found: " + e.getMessage());
	         }

	    //Check whether Password field exists or not
	     try
	        {
		 WebElement password = dr.findElement(By.id("phdesktopbody_0_password"));
	         System.out.println("Password exits -----");
	         password.sendKeys("Test@124#");
	        }
	    catch(Throwable e)
	        {
		 System.out.println("Password not found: " + e.getMessage());
	        }

	     //Asserting the Sign In button exists or not and clicking it
	    try
	       {
		WebElement button = dr.findElement(By.id("phdesktopbody_0_SIGN IN"));      
		System.out.println("Sign In Button exists -----");
	    //To uncheck the "Check sign in" checkbox
	    WebElement check_stay_sign_in = dr.findElement(By.id("phdesktopbody_0_checkboxrememberme"));
	    check_stay_sign_in.click();   
		button.click();
	        }
	    catch(Throwable e)
	        {
		System.out.println("Sign In Button not found: "+ e.getMessage());
	        }
	    //Check if login was proper or not
	    try
	        {
		WebElement SuccessfulMsg = dr.findElement(By.id("phdesktopbody_0_StepOneMessage"));
	        String text = SuccessfulMsg.getText();
	        if(text.equals("YOUR BASIC INFORMATION"))
	       {
		System.out.println("Login Sucessful -----");
	       }else
	       {
		System.out.println("Login Failed -----");
		}
	       }
	     catch(Throwable e)
	        {
		 System.out.println("Sign In Failed: "+e.getMessage());
	        }
	    
	  //Asserting and clicking on the Signout button.
	     try
	        {
		WebElement SignOff = dr.findElement(By.id("phdesktopheader_0_phdesktopheadertop_2_LogOffLink"));
	    System.out.println("Signout button exists -----");
	    SignOff.click();
	    WebElement LogOutonfirmation =dr.findElement(By.id("phdesktopheader_0_phdesktopheadertop_2_anchrContinue"));
        System.out.println("Signout Confirmation button exists -----");
        LogOutonfirmation.click();
        Thread.sleep(2000);
        WebElement SignOff1 = dr.findElement(By.id("phdesktopheader_0_phdesktopheadertop_2_LogOffLink"));
        System.out.println("Signout button exists -----");
        SignOff1.click();
        WebElement LogOutonfirmation1 =dr.findElement(By.id("phdesktopheader_0_phdesktopheadertop_2_anchrContinue"));
        System.out.println("Signout Confirmation button exists -----");
        LogOutonfirmation1.click();
	       }
	    catch(Throwable e)
	       {
		System.out.println(" Signout button not found: "+e.getMessage());
	        }
	     
	    //Check whether Signout was proper or not.
	    try
	       {	
	       WebElement ConfirmSignOutText = dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[1]"));
	       String text = ConfirmSignOutText.getText();
	       if(text.equals("Sign In"))
	       {
	       System.out.println("SignOut was successful -----");
	       }
	     else
	       {
	        System.out.println("SignOut wasn't successful -----");
	       }
	       }

	    catch(Throwable e)
	        {
		System.out.println("Signlink not found: "+e.getMessage());
		Thread.sleep(3000);
	        }
	}
	@Test(priority=3)
	public void Case2() throws InterruptedException
	{
		  // CASE- 2. Both Email and Password Fields are blank.
	  try
	  {
		WebElement button = dr.findElement(By.xpath("//*[@id=\"phdesktopheader_0_phdesktopheadertop_2_pnlCRMHeaderLink\"]/div/a[1]"));
		button.click();
		Thread.sleep(2000);
		WebElement button1=dr.findElement(By.id("phdesktopbody_0_SIGN IN"));
		button1.click();
		WebElement UserNameErrMsg = dr.findElement(By.id("phdesktopbody_0_usernameerrmsg"));
		String text = UserNameErrMsg.getText();
		WebElement PassswdErrMsg = dr.findElement(By.id("phdesktopbody_0_usernameerrmsg"));
		String text1 = PassswdErrMsg.getText();
		if(text.equals("This is a mandatory field.")&& text1.equals("This is a mandatory field."))
		{
			System.out.println("UserName and Passsword fields are blank -----");
		}
		else
		{
			System.out.println("UserName and Passsword fields are not blank -----");
		}
	}
	catch(Throwable e)
	{
		
		System.out.println("ElementNotfound: "+e.getMessage());
		Thread.sleep(4000);
	  }
	}
	@Test(priority=4)
	public void Case3() throws InterruptedException
	{
		// CASE- 3. Email field is filled and Password field is blank
	  try
	  {
		  WebElement UserName = dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_username"));
		  UserName.sendKeys("suy759@gmail.com");
		
		  WebElement button=dr.findElement(By.id("phdesktopbody_0_SIGN IN"));
		  button.click();
		
		  WebElement PassswdErrMsg = dr.findElement(By.id("phdesktopbody_0_passworderrmsg"));
		  String text = PassswdErrMsg.getText();
		  if(text.equals("This is a mandatory field."))
		{
			System.out.println("Passsword field is blank -----");
		}
		else
		{
			System.out.println("Passsword field is not blank -----");
		}
	}
	catch(Throwable e)
	{
		
		System.out.println("ElementNotfound: "+e.getMessage());
		
	}
	  dr.findElement(By.id("phdesktopbody_0_username")).clear();
	  Thread.sleep(4000);
	}
	@Test(priority=5)
	public void Case4() throws InterruptedException
	{
		// CASE- 4. Email field is blank and Password field is filled
	  try
	  {
		WebElement Passwd=dr.findElement(By.id("phdesktopbody_0_password"));
		Passwd.sendKeys("Test@124#");

		WebElement button=dr.findElement(By.id("phdesktopbody_0_SIGN IN"));
		button.click();
		WebElement UserNameErrMsg = dr.findElement(By.id("phdesktopbody_0_usernameerrmsg"));
		String text = UserNameErrMsg.getText();
		if(text.equals("This is a mandatory field."))
		{
			System.out.println("UserName field is blank -----");
		}
		else
		{
			System.out.println("UserName field is not blank -----");
		}
	}
	catch(Throwable e)
	{
		
		System.out.println("ElementNotfound: "+e.getMessage());
	  }
	  dr.findElement(By.id("phdesktopbody_0_password")).clear();
	  Thread.sleep(4000);
	}
	//CASE- 5. Email or Password are entered wrong 
	@Test(priority=6)
	public void Case5() throws InterruptedException 
	{
		try
		{
		WebElement WrongUserName = dr.findElement(By.name("phdesktopbody_0$phdesktopbody_0_username"));
		WrongUserName.sendKeys("debu12@gmail.com");
		WebElement WrongPasswd=dr.findElement(By.id("phdesktopbody_0_password"));
		WrongPasswd.sendKeys("Abcd1234#");
		
		WebElement button=dr.findElement(By.id("phdesktopbody_0_SIGN IN"));
		button.click();
		WebElement ErrMsg = dr.findElement(By.id("phdesktopbody_0_Message"));
		String text = ErrMsg.getText();
		if(text.equals("The email and password combination you entered is incorrect. Please try again, or click the link below to create an account."))
		{
			System.out.println("UserName or Password is Wrong -----");
		}
		else
		{
			System.out.println("UserName or Password is Wrong -----");
		}
	}
	catch(Throwable e)
	{
		
		System.out.println("ElementNotfound: "+e.getMessage());
	  }
		  dr.findElement(By.id("phdesktopbody_0_username")).clear();
	  Thread.sleep(4000);
	}
	//CASE- 6. Click on Change Password 
		@Test(priority=7)
		public void Case6() throws InterruptedException 
		{
			try
			{
				WebElement forgotPassword=dr.findElement(By.id("phdesktopbody_0_forgotpassword"));
				forgotPassword.click();
				Thread.sleep(2000);
				WebElement Desp=dr.findElement(By.id("phdesktopbody_0_Description"));
				String text = Desp.getText();
				if(text.equals("Please enter your e-mail address to reset your password."))
				{
					System.out.println("This is the Password Reset window -----");
				}
				else
				{
					System.out.println("This is not the Password Reset window -----");
				}
				WebElement PassResetEmail=dr.findElement(By.id("phdesktopbody_0_username"));
				PassResetEmail.sendKeys("suy759@gmail.com");
				WebElement NextButton=dr.findElement(By.id("phdesktopbody_0_NEXT"));
				NextButton.click();
				WebElement Message=dr.findElement(By.id("phdesktopbody_0_afterSubmit"));
				String text1 = Message.getText();
				if(text1.equals("We have sent an email to your email address, please click on the link in the email to reset your password."))
				{
					System.out.println("Mail has been sent to reset password -----");
				}
				else
				{
					System.out.println("Mail is not sent to reset password -----");
				}
			}
			catch(Throwable e)
			{
				System.out.println("PasswdButtonNotfound: "+e.getMessage());
			}
		}
		@AfterTest
		public void ExitBrowser()
		{
			dr.close();
		}
}
