package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomersPage {
	WebDriver driver;
	
	By emailAdd = By.cssSelector("input[name='filter_email']");
	By btnFilter = By.xpath("//button[contains(text(),' Filter')]");
	By editInfo = By.cssSelector("#form-customer > div.table-responsive > table > tbody > tr > td.text-end > div > a");
	By editsurname = By.cssSelector("#input-lastname");
	By btnSave = By.cssSelector("#content > div.page-header > div > div > button");
			
	public CustomersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@Test
	  public void searchCust() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(emailAdd));
		  driver.findElement(emailAdd).sendKeys("wnandini38@gmail.com");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(btnFilter));
		  driver.findElement(btnFilter).click();	
		  
	  }
	
  @Test
  public void editCustomer() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(editInfo));
	  driver.findElement(editInfo).click();
  }
  
  @Test
  public void updateDetails() {
	  driver.findElement(editsurname).clear();
	  driver.findElement(editsurname).sendKeys("waghmare");  
	  System.out.println("Updated surname");
  }
  
  @Test
  public void VerifyAcceesMsg() {
	  driver.findElement(btnSave).click(); 
	  System.out.println("Clicked Save succesfully");
  }
  
  @Test
  public void VerifyCustomerUpdate() {
	  String uplastname = driver.findElement(editsurname).getAttribute("value");
	  Assert.assertEquals(uplastname, "waghmare1", "Updated details are not reflected in admin correctly");
	  System.out.println("Updated details are reflected in admin correctly");
  }
}
