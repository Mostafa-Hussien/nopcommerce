package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadproperties;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTestDDTPropertiesFile extends TestBase {
	
	HomePage homeObject ; 
	UserRegistrationPage  registerObject ; 
	String firstname = loadproperties.userData.getProperty("firstname") ;
	String lastname = loadproperties.userData.getProperty("lastname") ;
	String email = loadproperties.userData.getProperty("email") ;
	String Password = loadproperties.userData.getProperty("password") ;
	
	@Test
	public void userCanRegisterSuccssfully ( )
	{
		homeObject = new HomePage(driver) ; 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver) ; 
		registerObject.userregistration(firstname , lastname ,email ,Password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}

}
