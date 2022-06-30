package Pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class LoginPage {
	WebDriver driver;
	
	By username = By.cssSelector("#input-username");
	By password = By.cssSelector("#input-password");
	By login = By.cssSelector("div.text-end > button");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
  @Test
  public void login() {
	  driver.findElement(username).sendKeys("demo");
	  System.out.println("Entered username succesfully");
	  driver.findElement(password).sendKeys("demo");
	  System.out.println("Entered password succesfully");
	  driver.findElement(login).click();
	  System.out.println("Navigated to open cart site succesfully");
  }
  
  
}


