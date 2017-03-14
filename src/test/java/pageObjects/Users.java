package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Users {
	
	WebDriver driver;
	
	public  Users(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']") WebElement Adminlink;
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']") WebElement UserManagementlink;
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']") WebElement Userlink;
	@FindBy(xpath="//div[@id='systemUser-information']/a") WebElement Sysuser;
	
	@FindBy(xpath=".//*[@id='menu_pim_viewPimModule']/b") WebElement pim;
	
	
	public boolean pimclick()
	{
		pim.click();
   boolean status=false;
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
	
	    
		try 
		{
			WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='menu_pim_viewEmployeeList']")));
			
			status = ele.isDisplayed();
		}
		catch (Exception e) 
		{
			System.out.println("element not found");
		}
		
	    return status;

	

	
	}	
}
