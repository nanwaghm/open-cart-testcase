package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustomerLoginPage {
	
	WebDriver driver;
	By myAccount = By.xpath("//span[contains(text(),'My Account')]");
	By acctLogin = By.xpath("//a[contains(text(),'Login')]");
	By acctEmail = By.cssSelector("#input-email");
	By acctPwd = By.cssSelector("#input-password");
	By acctLoginbtn = By.cssSelector("#form-login > button");
	
	
	
	public CustomerLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
  @Test
  public void GotocustomerAccountLogin() {
	  driver.findElement(myAccount).click();
	  System.out.println("Navigatede to My Account");
	  driver.findElement(acctLogin).click();
	  System.out.println("Navigatede to Account Login page");
  }
  
  public void loginToCustomerAccount() throws InterruptedException {
	  driver.findElement(acctEmail).sendKeys("wnandini38@gmail.com");
	  System.out.println("Entered Customer email address successfully");
	  driver.findElement(acctPwd).sendKeys("abc@11");
	  System.out.println("Entered Password successfully");
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.elementToBeClickable(acctLoginbtn));
	  Thread.sleep(1000);
	  driver.findElement(acctLoginbtn).click();
	  System.out.println("Logged in to Customer Account successfully");
	  	  
  }
}
  
