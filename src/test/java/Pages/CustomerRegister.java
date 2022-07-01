package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustomerRegister {
	
	WebDriver driver;
	By myAccount = By.xpath("//span[contains(text(),'My Account')]");
	By register = By.xpath("//a[contains(text(),'Register')]");
	By firstName = By.cssSelector("#input-firstname");
	By lastName = By.cssSelector("#input-lastname");
	By custemail = By.cssSelector("#input-email");
	By custpwd = By.cssSelector("#input-password");
	By custermCont = By.cssSelector("input[name='agree']");
	By btnContinue = By.xpath("//button[contains(text(),'Continue')]");
			
			
	public CustomerRegister(WebDriver driver) {
		this.driver=driver;
	}
		

  @Test
  public void launchCustUrl() {
		driver.get("https://demo.opencart.com/");
		System.out.println("Launched Customer URL");
  }
  
  @Test
  public void gotoRegisterCustomer() {
	  driver.findElement(myAccount).click();
	  System.out.println("Navigated to My Account");
	  driver.findElement(register).click();
	  System.out.println("Navigated to register page successfully");
  }
  @Test
  public void registerCustomer() throws InterruptedException {
	  
	  driver.findElement(firstName).sendKeys("nandini");
	  System.out.println("Entered firsname");
	  driver.findElement(lastName).sendKeys("wagh");
	  System.out.println("Entered lastname");
	  driver.findElement(custemail).sendKeys("jetiha2539@kahase.com");
	  System.out.println("Entered email");
	  driver.findElement(custpwd).sendKeys("abc@122");
	  System.out.println("Entered password");
	  driver.findElement(custermCont).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
	  Thread.sleep(1000);
	  driver.findElement(btnContinue).click(); 
	  System.out.println("Clicked Register");
}
  
}
