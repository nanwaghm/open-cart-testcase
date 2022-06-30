package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustAddressPage {
	
	WebDriver driver;
	By emailAdd = By.xpath("(//a[contains(text(),'Addresses')])[1]");
	By add = By.cssSelector("#input-address-0-address-1");
	By btnSave = By.cssSelector("#content > div.page-header > div > div > button");
	
	public CustAddressPage(WebDriver driver) {
		this.driver=driver;
	}
  @Test
  public void updateAdd() {
	  driver.findElement(emailAdd).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(add));
	  driver.findElement(add).sendKeys("Kukataplly");
	  driver.findElement(btnSave).click();
	  
  }
}
