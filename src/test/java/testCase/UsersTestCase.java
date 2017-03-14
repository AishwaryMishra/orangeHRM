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
import pageObjects.Users;
import utility.Helper;

public class UsersTestCase extends baseClass{

	
ExtentTest logger;
	

	

	@Test(priority=2)
	public void getUserPage()
	{
		
		Users us=PageFactory.initElements(driver, Users.class);
		us.pimclick();
	
/*	if (status) {
		logger.log(LogStatus.PASS, "User is able to find pim ");

		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshots(driver)));
	} else {
		logger.log(LogStatus.FAIL, "User is not able to find pim");
*/
		
		/*us.AdminMouseHover();
		us.UsermanagementMouseHover();
		us.clickonUsers();
		*/
	//}
	}	
}
