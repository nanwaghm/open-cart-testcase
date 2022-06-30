package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CustAddressBookPage {
	
	WebDriver driver;
	
	By addressBookLnk = By.xpath("#column-right > div > a:nth-child(4)");
	By editAdd = By.xpath("(//a[contains(text(),'Edit')])[1]");
	By addFld = By.xpath("//input[@name='address_1']");
	By btnContinue = By.xpath("//button[contains(text(),'Continue')]");
	
	public CustAddressBookPage(WebDriver driver) {
		this.driver=driver;
	}
	
  @Test
  public void GotoAddBook() {
	  driver.findElement(addressBookLnk).click();
	  driver.findElement(editAdd).click();
	  driver.findElement(addFld).sendKeys("Sevalal Nagar");
	  driver.findElement(btnContinue).click();
  }
}
