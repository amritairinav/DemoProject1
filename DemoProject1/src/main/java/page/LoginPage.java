package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {
	
	@FindBy(name="username")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement submit;
	@FindBy(xpath="//label[@for='remember']")WebElement rememberme;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(css="button[data-dismiss='alert']") WebElement alert;
	/*@FindBy(id="uploadFile")WebElement chooseFile;

	public void uploadImage(String path) {
	    chooseFile.sendKeys(path);
	}*/
	
	WebDriver driver;
	PageUtility obj=new PageUtility();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void entertheusername(String Username1) {
		username.sendKeys(Username1);
	}
	public void enterthepassword(String password1) {
		password.sendKeys(password1);
	}
	
	public void checkthecheckboxrememberme() {
		rememberme.click();
	}
	
	
	/*public void dropdown()
	{
		PageUtility obj=new PageUtility();
		obj.dropdownVisibleText(password, null);
		obj.dropdownValue(password, null);
		obj.dropdownIndex(password, 0);
		obj.simpleAlertaccept(driver);
		obj.confirmationAlertdismiss(driver);
		obj.getAlertText(driver);
		obj.enterTextpromptalert(driver, null);
	}*/
	
	
	public void clicksignin() {
		submit.click();
	}
	
	/*public void uploadImage(String path) {
	    chooseFile.sendKeys(path);
	}*/
	
	 public boolean isdashBoarddisplayed() {
	        return dashboard.isDisplayed();
		
}
	 public boolean isalertdisplayed() {
	        return alert.isDisplayed();
}
	 public String validationMessage() {
		 return username.getAttribute("ValidationMessage");
	 
	 }
}
