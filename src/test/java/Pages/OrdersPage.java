package Pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.org.objectweb.asm.Constants;

public class OrdersPage {
	int Price = 0;
	List<WebElement> lstOrderPrice;
	List<WebElement> lstOrderdate;
	List<WebElement> pagination;
	WebDriver driver;
	
	By orederPrice = By.cssSelector("div.table-responsive > table tbody  td:nth-child(6)");
	By orederDate = By.cssSelector("div.table-responsive > table tbody  td:nth-child(7)");
	By nextpage = By.xpath("(//a[@class='page-link'])[4]");
	
	public OrdersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@Test
  public void calculatePrice() throws ParseException, InterruptedException {
		
		double ordPrice, totalp = 0;
		HashMap <String, Double> hmap = new HashMap <String, Double>();
		lstOrderPrice = driver.findElements(orederPrice);
		lstOrderdate = driver.findElements(orederDate);			
		pagination = driver.findElements(By.cssSelector("ul.pagination li a"));
	    int pageCount = pagination.size();
	    for(int j=0;j<=pageCount-2;j++){	
			for(int i=0; i<=lstOrderdate.size()-1; i++) {
				String price = lstOrderPrice.get(i).getText().replace("$", "").replace(",", "").replace("€", "");
				NumberFormat f =NumberFormat.getNumberInstance(); 
				Number num = f.parse(price);			
	            ordPrice = Double.parseDouble(price); 
	            if (hmap.containsKey(lstOrderdate.get(i).getText())) {
	                totalp = hmap.get(lstOrderdate.get(i).getText());
	                totalp = totalp + ordPrice;
		            hmap.put(lstOrderdate.get(i).getText(), totalp);
		         } else {		        	 
		            hmap.put(lstOrderdate.get(i).getText(), ordPrice);
		         }     
			}
			
			if (j==0) {
				pagination.get(pageCount-2).click();
			}
			else {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				List<WebElement> pagination1= driver.findElements(By.cssSelector("ul.pagination li a"));
				int newpagecount = pagination1.size();
				wait.until(ExpectedConditions.elementToBeClickable(pagination1.get(newpagecount-2)));
				pagination1.get(newpagecount-2).click();
				
			}
			
			Thread.sleep(5000);
			lstOrderPrice = driver.findElements(orederPrice);
			lstOrderdate = driver.findElements(orederDate);
		
	}
	    System.out.println(hmap);
	    writeValueToFile(hmap);
  }
	
	@Test
	
		public void writeValueToFile(HashMap hmap1){   
			String outputFilePath ="C:\\Users\\nandini.waghmare\\eclipse-workspace\\demo1\\OpenCart_demo\\PrintValues.txt";
		    File file = new File(outputFilePath);		
		    BufferedWriter bfw = null;
		    
		    try {
		        bfw = new BufferedWriter(new FileWriter(file));		        
		        Set keys = hmap1.keySet();
		        for (Iterator i = keys.iterator(); i.hasNext(); ) {
		            String key = (String) i.next();
		            Double value = (Double) hmap1.get(key);
		            bfw.write(key + " - USD " + value);
		            bfw.newLine();
		        }
		        	bfw.flush();
		    }
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		    finally { 
		        try {      
		            bfw.close();
		            System.out.println("Successfully wrote values to files" +outputFilePath);
		        }
		        catch (Exception e) {
		        }
		    }
		}

}




