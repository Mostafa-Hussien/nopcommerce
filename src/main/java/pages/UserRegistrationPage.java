package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="gender-male")
	WebElement genderRdoBtn ; 
	
	@FindBy (id= "FirstName")
	WebElement fnTxtBox ; 
	
	@FindBy (id= "LastName")
	WebElement lnTxtBox ; 
	
	@FindBy (id= "Email")
	 WebElement emailTxtBox ; 
	
	@FindBy(id="Password")
	WebElement passwordTxtBox ;
	
	@FindBy (id="ConfirmPassword")
	WebElement confirmpasswordTxtBox ; 
	
	@FindBy (id= "register-button")
	WebElement registerBtn ; 
	
	@FindBy (css ="div.result")
	public WebElement successMessage ; 
	
	@FindBy (className= "ico-logout")
	WebElement logoutBtn ; 
	
	public void userregistration (String firstName , String lastName, String email , String password){
		
		clickButton(genderRdoBtn);
		setTextEelemetText(fnTxtBox, firstName);
		setTextEelemetText(lnTxtBox, lastName);
		setTextEelemetText(emailTxtBox, email);
		setTextEelemetText(passwordTxtBox, password);
		setTextEelemetText(confirmpasswordTxtBox, password);
		clickButton(registerBtn); 
		
	}
	
	public void userLogout ( ) 
	{
		clickButton(logoutBtn);
	}
	
	

}
