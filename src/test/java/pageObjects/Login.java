package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Login {

	WebDriver driver;
	
	public Login(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@id='txtUsername']") WebElement username;
	@FindBy(xpath="//input[@id='txtPassword']") WebElement password;
	@FindBy(xpath="//input[@id='btnLogin']") WebElement clickloginbutton;
	
	/*public void clickonLoginbutton(String usname,String pass)
	{
		
		username.sendKeys(usname);
		password.sendKeys(pass);
		clickloginbutton.click();
		
	}*/
	
	public boolean clickonLoginbutton(String uname,String pass)
	{
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		clickloginbutton.click();
		

	    boolean status=false;
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
	
	    
		try 
		{
			WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='menu_admin_viewAdminModule']")));
			
			status = ele.isDisplayed();
		}
		catch (Exception e) 
		{
			System.out.println("element not found");
		}
		
	    return status;
	}
	
	
	
}
