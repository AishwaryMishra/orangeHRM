package testCase;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import pageObjects.Login;
import utility.Helper;

public class LoginTestCase extends baseClass {
	
	//WebDriver driver;
	//ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		
		logger =report.startTest("Login to CRM Application");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()== ITestResult.FAILURE)
		{
			
			logger.log(LogStatus.FAIL,logger.addScreenCapture(Helper.captureScreenshots(driver)));
			
		}
	
		report.endTest(logger);
	}
	
	@Test
	public void loginintoApplication()
	{
		
		Login login=PageFactory.initElements(driver, Login.class);
		boolean status=login.clickonLoginbutton(DataProviderFactory.getexcel().getData("Login", 1, 0), DataProviderFactory.getexcel().getData("Login", 1, 1));
	
	if (status) {
		logger.log(LogStatus.PASS, "User is able to login");

		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshots(driver)));
	} else {
		logger.log(LogStatus.FAIL, "User is not able to login");

		Assert.assertTrue(status);
	}
	}

}
