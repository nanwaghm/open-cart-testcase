package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;
	By secnote = By.xpath("//button[@class='btn-close']");
	By orderLink = By.cssSelector("#content > div.container-fluid > div:nth-child(1) > div:nth-child(1) > div > div.tile-footer > a");
	By lnkcustMain = By.cssSelector("#menu-customer");
	By lnkcustOpt = By.cssSelector("#collapse-5 > li:nth-child(1) > a");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
  @Test
  public void navigateOrders() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(secnote));
	  driver.findElement(secnote).click();
	  driver.findElement(orderLink).click();
	  System.out.println("Navigated Order summary succesfully");
  }
  
  @Test
  public void navigateCustomers() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(secnote));
	  driver.findElement(secnote).click();
	  wait.until(ExpectedConditions.elementToBeClickable(lnkcustMain));
	  driver.findElement(lnkcustMain).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(lnkcustOpt));
	  driver.findElement(lnkcustOpt).click();
  }
}
