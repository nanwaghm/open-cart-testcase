package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EditAccountPage {
	
	WebDriver driver;
	By editAccount = By.cssSelector("#column-right > div > a:nth-child(2)");
	By lastName = By.cssSelector("#input-lastname");
	By btnSubmit = By.xpath("//button[@type='submit']");
	
	public EditAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
  @Test
  public void GotoEditAccount() {
	  driver.findElement(editAccount).click();
	  System.out.println("Navigated to Edit Account");
  }
  
  @Test
  public void UpdateAccountInfo() throws InterruptedException {
	  driver.findElement(lastName).clear();
	  driver.findElement(lastName).sendKeys("waghmare1");
	  Thread.sleep(1000);
	  driver.findElement(btnSubmit).click();
	  System.out.println("Updated Account information");
  }
  
  
}
