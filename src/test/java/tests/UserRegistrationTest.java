package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObject ; 
	UserRegistrationPage  registerObject ; 
	
	@Test
	public void userCanRegisterSuccssfully ( )
	{
		homeObject = new HomePage(driver) ; 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver) ; 
		registerObject.userregistration("Mostafa", "Hussien", "mostafa152@gmai.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}

}
