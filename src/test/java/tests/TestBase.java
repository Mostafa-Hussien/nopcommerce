package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;


public class TestBase {


	public static WebDriver driver ; 

	@BeforeMethod
	@Parameters({"browser"})
	public void startDriver (@Optional("chrome") String browserName) 
	{
		
		if (browserName.equalsIgnoreCase("chrome")) {
			String chromepath = System.getProperty("user.dir")+"//Drivers//chromedriver.exe" ;
			System.setProperty("webdriver.chrome.driver", chromepath) ; 
			driver = new ChromeDriver() ; 	
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			String fireFoxpath = System.getProperty("user.dir")+"//Drivers//geckodriver.exe" ;
			System.setProperty("webdriver.gecko.driver", fireFoxpath) ; 
			driver = new FirefoxDriver() ;
		}
		

		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		driver.navigate().to("https://demo.nopcommerce.com/");
	}


	@AfterMethod
	public void stopDriver ( ) {

		driver.quit(); 
	}
	
	@AfterMethod
	public void screenshotFailure (ITestResult result )
	{   // take screenshot when the testCase fail in Screenshots folder 
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot......");
			Helper.screenShotCapture(driver, result.getName());
		}
		
	}
}
