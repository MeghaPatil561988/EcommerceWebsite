package Academy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Utility;
import Resources.base;
import pageObjects.landingPage;


public class LandingPagetestcase extends base{
	public WebDriver driver;
	base b=new base();
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 driver.get(prop.getProperty("url")); 
	
	}
	
	@Test(priority=0)
	public void popularcatagory() 
	{
		 
		 landingPage l = new  landingPage(driver);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		 //click on logo
		  driver.findElement(By.className("logo")).click();
		 
		 
		//Collect product name and Number of jobs in HashMap
	       HashMap<String, String> productcontainerMap = new HashMap<String, String>();

	        //This code below will collect product Names in an ArrayList
	        ArrayList<String> products = new ArrayList<String>();
	        List<WebElement> pnames = l.getProductnames();
	        for (WebElement ele : pnames) 
	        {
	        	products.add(ele.getText());
	        	Collections.sort(products);
	        	
	        }
	        ArrayList<String> price = new ArrayList<String>();
	        List<WebElement> pprice = l.getProductprices();
	        for (WebElement ele : pprice)
	        {
	        	price.add(ele.getText());
	        	Collections.sort(price);
	        	
	        }
	        for (int i = 0, j = 0; i < products.size() && j < price.size(); i++, j++) 
	        {
	        	productcontainerMap.put(products.get(i),price.get(j));
	        	
	        }
	        
	        TreeMap<String,String> sorted = new TreeMap<>(productcontainerMap);
	        System.out.println(sorted);
	        
	       }
	
	
    @Test(priority=1)
	public void NavigateToWomen() throws InterruptedException {
        
		 landingPage l = new  landingPage(driver);
		 Utility utility = new Utility(driver);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
        
			js.executeScript("window.scrollBy(0,-500)");
			
			
			
			//navigate to women>> Dresses >> Evening Dresses
			Actions a = new Actions(driver);
			a.moveToElement(l.geteveningdresses()).build().perform();
			System.out.println("navigate to women");
			js.executeScript("arguments[0].click();", l.geteveningdresses());
			System.out.println("clicked on Evening Dresses");
			js.executeScript("arguments[0].click();",l.getsize());
			System.out.println("selected size");
			js.executeScript("arguments[0].click();",l.getcolor());
			System.out.println("selected color");
			js.executeScript("window.scrollBy(0,800)");
			
			   actions.clickAndHold(l.getslider());
			   actions.moveToElement(l.getslider(), 50, (int) 50.28);
			   actions.build().perform();     
			   actions.moveToElement(l.getSecondImg()).moveToElement( l.getmorebtn()).click().perform(); 
			 for(int i=1;i<3;i++)
				{
				  l.getplusicon().click();//3 times
				}
			 
			actions.moveToElement(l.getsizedropdown()).click().perform();
			WebElement element = l.getsizeM();
			element.click();
			 
			 js.executeScript("window.scrollBy(0,500)");
			 l.getprodcolor().click();
			 System.out.println(l.getprodcolor().getText());
			 
			 l.getaddtocart().click();
			 System.out.println( l.getprodcolor().getText());
			 
			 String actual;
				String expt = "Pink, M";
				actual=l.getcolorsize().getText();
				System.out.println("Product Color and Size Successfully displayed "+actual);
				Assert.assertEquals(actual, expt);
				
				String actualquantity;
				String exptquantity ="3";
				actualquantity = l.getquantity().getText();
				System.out.println("Product Quantity Successfully displayed "+actualquantity);
				Assert.assertEquals(actualquantity, exptquantity);
				
				String actualtotal;
				String expttotal ="$152.97";
				actualtotal =l.gettotal().getText();
				System.out.println("Product Total Successfully displayed "+actualtotal);
				Assert.assertEquals(actualtotal,expttotal);
				
				
				//Verify total cost (total product cost + shipping cost)
				//Total products $152.97
				//Total shipping  $2.00
				//Total $154.97

				String actualprototal;
				String exptprototal ="$152.97";
				actualprototal =l.getproductscost().getText();
				System.out.println("Total Product  "+actualprototal);
				Assert.assertEquals(actualprototal,exptprototal);
				
				String actualproshcost;
				String exptproshcost ="$2.00";
				actualproshcost =l.getshippingcost().getText();
				System.out.println("Total Shipping "+actualproshcost);
				Assert.assertEquals(actualproshcost,exptproshcost);
				
				
				String actualtotalcount;
				String expttotalcount ="$154.97";
				actualtotalcount =l.getcount().getText();
				System.out.println("Total "+actualtotalcount);
				Assert.assertEquals(actualtotalcount,expttotalcount);
		}
	
	
	 @AfterTest()
	    public void teardown() {
	    	driver.close();
	    }
}
