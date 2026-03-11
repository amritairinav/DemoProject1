package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static final int IMPLICITWAIT = 5;
	public static final int EXPLICITWAIT = 10;

	WebDriver driver;
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
    public Alert waitForAlert() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }

     public void dismissAlert() {
    	 Alert alert = waitForAlert();
         alert.accept();
    }
     public void sendTextToAlert(String text) {
         Alert alert = waitForAlert();
         alert.sendKeys(text);
         alert.accept();
}
}

