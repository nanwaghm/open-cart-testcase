package TestCases;

import org.testng.annotations.Test;

import Pages.CustAddressBookPage;
import Pages.CustAddressPage;
import Pages.CustomerLoginPage;
import Pages.CustomersPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrdersPage;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestCasePrice {
	public WebDriver driver;	
	
	
  @BeforeSuite
  public void beforeSuite() {  	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\eclipse-workspace\\demo1\\OpenCart_demo\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
  }
  
  @Test
  public void priceCalculation() throws ParseException, InterruptedException {
	  LoginPage loginp = new LoginPage(driver);
	  HomePage homepg = new HomePage(driver);
	  OrdersPage Orderpg = new OrdersPage(driver);
	  
	  loginp.login();
	  homepg.navigateOrders();
	  Orderpg.calculatePrice();
  }

  @Test
  public void updateCustomerInfo() throws ParseException, InterruptedException {
	  LoginPage loginp = new LoginPage(driver);
	  HomePage homepg = new HomePage(driver);
	  CustomersPage custpg = new CustomersPage(driver);
	  CustomerLoginPage custlgpg = new CustomerLoginPage(driver);
	  CustAddressPage custAddpag = new CustAddressPage(driver);
	  CustAddressBookPage custaddbkpag = new CustAddressBookPage(driver);	  
	  
	  loginp.login();
	  homepg.navigateCustomers();
	  custpg.searchCust();
	  custpg.editCustAddress();
	  custAddpag.updateAdd();
	  custlgpg.GotocustomerAccountLogin();
	  custlgpg.loginToCustomerAccount();
	  custaddbkpag.GotoAddBook();
	
  }
  @AfterSuite
  public void afterSuite() {
	  //driver.close();
	  
  }

}
