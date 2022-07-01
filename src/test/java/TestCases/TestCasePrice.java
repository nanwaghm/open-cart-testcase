package TestCases;

import org.testng.annotations.Test;

import Pages.CustAddressBookPage;
import Pages.CustAddressPage;
import Pages.CustomerLoginPage;
import Pages.CustomerRegister;
import Pages.CustomersPage;
import Pages.EditAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrdersPage;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestCasePrice {
	public WebDriver driver;	
	
	
  @BeforeMethod
  public void beforeSuite() throws InterruptedException {  	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\eclipse-workspace\\demo1\\OpenCart_demo\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void priceCalculation() throws ParseException, InterruptedException {
	  LoginPage loginp = new LoginPage(driver);
	  HomePage homepg = new HomePage(driver);
	  OrdersPage Orderpg = new OrdersPage(driver);
	  
	  loginp.launchOpenCartAdmin();
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
	  CustomerRegister custRegister = new CustomerRegister(driver);
	  EditAccountPage editCustPage = new EditAccountPage(driver);
	  
	  custRegister.launchCustUrl();
	  custRegister.gotoRegisterCustomer();	 
	  custRegister.registerCustomer();
	  loginp.launchOpenCartAdmin();
	  loginp.login();
	  homepg.navigateCustomers();
	  custpg.searchCust();
	  custpg.editCustomer();
	  custpg.updateDetails();
	  custpg.VerifyAcceesMsg();
	  custRegister.launchCustUrl();
	  custlgpg.GotocustomerAccountLogin();
	  custlgpg.loginToCustomerAccount();
	  editCustPage.GotoEditAccount();
	  editCustPage.UpdateAccountInfo();
	  loginp.launchOpenCartAdmin();
	  loginp.login();
	  homepg.navigateCustomers();
	  custpg.searchCust();
	  custpg.editCustomer();
	  custpg.VerifyCustomerUpdate();
	  
  }
  
  
  @AfterMethod
  public void afterSuite() {
	  //driver.close();
	  
  }

}
