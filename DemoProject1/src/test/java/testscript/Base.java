package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;
import utilities.Wait;

public class Base {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void initialiseBrowser(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            
        }
        else {
            throw new Exception("Invalid Browser: " + browser);
        }

        driver.get("https://groceryapp.uniqassosiates.com/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
        
   @AfterMethod(alwaysRun = true)
   public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
			ScreenshotUtility screenshot=new ScreenshotUtility();
			screenshot.getScreenshot(driver, iTestResult.getName());
		}
		
		driver.quit();
	}
}