package testscript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test (priority=1,groups = {"Regression"},retryAnalyzer=retry.Retry.class description ="Verify login functionaility")
	
	public void verifyiftheuserisabletologinwithvalidcredentials() throws IOException {
		//String username1="admin";
		//String password1="admin";
		String username1 = ExcelUtility.getStringdata(1, 0, "LoginPage");
	    String password1 = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.entertheusername(username1);
		obj.enterthepassword(password1);
		obj.checkthecheckboxrememberme();
		obj.clicksignin();
		boolean page=obj.isdashBoarddisplayed();
		Assert.assertTrue(page);
}
	@Test (priority=2,groups = {"Regression"} description ="Verify login functionaility")
	public void verifyiftheuserisabletologinwithcorrectusernameandincorrectpassword() throws IOException {
		//String username1="admin1";
		//String password1="admin2";
		String username1 = ExcelUtility.getStringdata(2, 0, "LoginPage");
	    String password1 = ExcelUtility.getStringdata(2, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.entertheusername(username1);
		obj.enterthepassword(password1);
		obj.checkthecheckboxrememberme();
		obj.clicksignin();
		boolean message=obj.isalertdisplayed();
		Assert.assertTrue(message);
}
	@Test (priority=3,groups = {"Regression"} description ="Verify login functionaility")
	
		public void verifyiftheuserisabletologinwithincorrectusernameandcorrectpassword() throws IOException {
		String username1 = ExcelUtility.getStringdata(3, 0, "LoginPage");
	    String password1 = ExcelUtility.getStringdata(3, 1, "LoginPage");
			LoginPage obj=new LoginPage(driver);
			obj.entertheusername(username1);
			obj.enterthepassword(password1);
			obj.checkthecheckboxrememberme();
			obj.clicksignin();
			boolean message=obj.isalertdisplayed();
			Assert.assertTrue(message);
	}
	@Test (priority=4,groups = {"Regression"} description ="Verify login functionaility")
	
	public void verifyiftheuserisabletologinwithincorrectusernameandincorrectpassword() throws IOException {
		String username1 = ExcelUtility.getStringdata(4, 0, "LoginPage");
	    String password1 = ExcelUtility.getStringdata(4, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.entertheusername(username1);
		obj.enterthepassword(password1);
		obj.checkthecheckboxrememberme();
		obj.clicksignin();
		boolean message=obj.isalertdisplayed();
		Assert.assertTrue(message);
}
	@Test (priority=5,groups = {"Regression"} description ="Verify login functionaility")
	public void verifyiftheuserisabletologinwithnousernameandpassword() throws IOException {
		String username1 = ExcelUtility.getStringdata(5, 0, "LoginPage");
	    String password1 = ExcelUtility.getStringdata(5, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.entertheusername(username1);
		obj.enterthepassword(password1);
		obj.checkthecheckboxrememberme();
		obj.clicksignin();
		//obj.uploadImage(Constant.IMAGEFILE);
		Assert.assertEquals("Please fill in this field.", "Please fill in this field.");
}
}

