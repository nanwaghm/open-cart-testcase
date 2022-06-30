package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustomersPage {
	WebDriver driver;
	
	By emailAdd = By.cssSelector("input[name='filter_email']");
	By btnFilter = By.xpath("//button[contains(text(),' Filter')]");
	By editInfo = By.cssSelector("#form-customer > div.table-responsive > table > tbody > tr > td.text-end > div > a");
	
	public CustomersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@Test
	  public void searchCust() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(emailAdd));
		  driver.findElement(emailAdd).sendKeys("jetiha2539@kahase.com");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(btnFilter));
		  driver.findElement(btnFilter).click();		  
	  }
	
  @Test
  public void editCustAddress() {
	  driver.findElement(editInfo).click();
  }
}
