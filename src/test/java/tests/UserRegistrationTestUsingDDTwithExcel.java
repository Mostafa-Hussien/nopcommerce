package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTestUsingDDTwithExcel extends TestBase {

	HomePage homeObject ; 
	UserRegistrationPage  registerObject ; 


	@DataProvider (name ="ExcelData")
	public Object[][] userRegisterData() throws IOException 
	{
		// get data from excel reader class 
		ExcelReader er = new ExcelReader() ; 

		return 	er.getExcelData() ; 
	}

	@Test (alwaysRun = true , dataProvider = "ExcelData")
	public void userCanRegisterSuccssfully (String firstname , String lastname , String email ,String password )
	{
		homeObject = new HomePage(driver) ; 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver) ; 
		registerObject.userregistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		//registerObject.userLogout();

	}

}
