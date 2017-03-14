package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pageObjects.Login;
import utility.CustomDateFormat;
import utility.Helper;

public class baseClass {
	
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeSuite
	public void startReport()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/Reports/CRM"+CustomDateFormat.getCurrentTime()+".html");
	}
	
	@AfterSuite
	public void closeReport()
	{
		report.flush();
	}
	
	@BeforeTest
	public void startBrowser() 
	{
		System.out.println("========== Starting Browser==================");
		driver=BrowserFactory.startBrowser(DataProviderFactory.getConfig().getBrowser(), DataProviderFactory.getConfig().getURL());
		
		System.out.println("========== Browser Started and Application is running==================");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
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
