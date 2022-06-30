package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	  driver.findElement(acctLogin).click();
	  	  
  }
  
  public void loginToCustomerAccount() {
	  driver.findElement(acctEmail).sendKeys("");
	  driver.findElement(acctPwd).sendKeys("");
	  driver.findElement(acctLoginbtn).click();
	  	  
  }
  
}
