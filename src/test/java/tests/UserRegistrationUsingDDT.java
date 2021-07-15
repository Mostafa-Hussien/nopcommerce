package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationUsingDDT extends TestBase {
	
	HomePage homeObject ; 
	UserRegistrationPage  registerObject ; 
	
	@DataProvider (name="testData")
	public static Object [] [] userData () 
	{
		return new Object [][] {
			{"Mostafa", "Hussien", "mostafaxc@gmai.com", "12345678"},
			{"mohamed", "ali", "mohamedxs@gmai.com", "12345678"}
			} ;
	}
	
	@Test (dataProvider="testData")
	public void userCanRegisterSuccssfully (String fname ,String lname ,String email ,String password )
	{
		homeObject = new HomePage(driver) ; 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver) ; 
		registerObject.userregistration(fname , lname , email , password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();	
	}
	
	/* @Test(dependsOnMethods= {"userCanRegisterSuccssfully"})
	public void ResgisteredUserCanLogout () 
	{
		registerObject.userLogout();
	} */

}
