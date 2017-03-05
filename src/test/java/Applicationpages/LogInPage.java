//package Applicationpages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindBy;
//
////import dataProvider.ExcelDataProvider;
//
//public class LogInPage {
//	WebDriver driver;
//	public LogInPage(WebDriver ldriver){
//		this.driver =ldriver;
//	}
//	
//	ExcelDataProvider read = new ExcelDataProvider();
//	
//	@FindBy(xpath = "//*[@id='account_sign_in_form_email_id']")
//	WebElement inputEmailId;
//	
//	@FindBy(xpath="//*[id='account_sign_in_form_passwd_id')"
//	WebElement inputPassword1;
//	
////	@FindBy(how=How.LINK_TEXT,using="Forgot your password?")
////	@CacheLookup
////	WebElement ForgotPasswordLink;
//	
//	driver.FindElement(By.LinkText("Forgot your Password")).Click();
//			
//	@FindBy(xpath = "//input[@class = 'input_checkbox']")
//	WebElement inputCheckbox;
	
package Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {
	
    WebDriver driver;
	
	public void LoginPage(WebDriver ldriver){
		
		this.driver = ldriver;
		
	}
	
	@FindBy(id="account_sign_in_form_email_id")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement login;
	
	@FindBy(xpath="//a[text()=' Dashboard ']//following::div[2]")
	WebElement dashboardtitle;
	
	public void loginApplication(String uname, String pass){
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		login.click();
	}

	public void verifyDashboardTitle(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(dashboardtitle));
		
		String text = ele.getText();
		
		Assert.assertEquals(text, "Account Dashboard View","Dashboard title not verified properly.");
	}
}

	
	
	
	
	
	
	
	
			
	
	
	
	
	
	
	




