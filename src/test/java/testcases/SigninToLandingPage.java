package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters.BigDecimalConverter;
import org.apache.poi.hssf.model.ConvertAnchor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninToLandingPage {

	public static void main(String[] args) throws InterruptedException 
	{
		
		/*
		 Steps to Automate:
         1. Open link http://automationpractice.com/index.php
         2. Login to the website.
		 */
		
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  String URL="http://automationpractice.com/index.php";
		  
		  // Open URL and Maximize browser window
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		  
		  //Click on Sign in
		  driver.findElement(By.linkText("Sign in")).click();
		  System.out.println("clicked on signin button");
		 // Thread.sleep(2000);
		  
		//Login
		  driver.findElement(By.id("email")).sendKeys("testautomationmfs@gmail.com");
		  driver.findElement(By.id("passwd")).sendKeys("TestAutomation@123");
		  driver.findElement(By.id("SubmitLogin")).click();
		  System.out.println("clicked on login button");
		  
		  //click on logo
		  driver.findElement(By.className("logo")).click();
		  System.out.println("clicked on logo back to landing page");
		  
		  //On landing page, under POPULAR category we see a list of apparels. 
		  //Get the Label and associated Price of those item. 
		  //Fetch them and sort it as per their price [Lowto High] and print it on Console [Label and Price]
        
		 
		 //List<WebElement> products = driver.findElements(By.cssSelector("a.product-name"));
		 //List<WebElement> productprice = driver.findElements(By.xpath("//div[@class='product-container']//div[@class='content_price']"));
		  
		
	       HashMap<String, String> productcontainerMap = new HashMap<String, String>();

	        //This code below will collect product Names in an ArrayList
	        ArrayList<String> products = new ArrayList<String>();
	        List<WebElement> productnames = driver.findElements(By.cssSelector("a.product-name"));
	        for (WebElement ele : productnames) 
	        {
	        	products.add(ele.getText());
	        	
	        }

	        //This code below will get price value in an arraylist and add to HashMap
	        ArrayList<String> price = new ArrayList<String>();
	        List<WebElement> productprice = driver.findElements(By.cssSelector("span.price.product-price"));
	        for (WebElement ele : productprice)
	        {
	        	
	        	price.add(ele.getText()); 
	        	//price.sort(ele);
	        	
			}
	    
	        
	        for (int i = 0, j = 0; i < products.size() && j < price.size(); i++, j++) 
	        {
	        	
	        	
	        	productcontainerMap.put(products.get(i),price.get(j));
	        }
	        
	      
	       for(Map.Entry<String,String> mm:productcontainerMap.entrySet())
	    	   
	        {
	            System.out.println(mm.getKey() +"  " + mm.getValue());
	            
	        }
	       
	       
	     /*   Set s=productcontainerMap.entrySet();
	        Iterator is=s.iterator();
	        while(is.hasNext())
	        {
	            Map.Entry m= (Map.Entry)is.next();
	            System.out.println(m.getKey()+"  =>  "+m.getValue()); //get values
	        }
		 */
	      
		/*  List<WebElement> productprice = driver.findElements(By.cssSelector("span.price.product-price"));
		  System.out.println(productprice.size());
		  for (int i = 0; i < productprice.size(); i++)
          {
			  List<String> prices = new ArrayList<String>();
			  prices.add(productprice.get(i).getText());
			  System.out.println(prices);
		  
		  List<String> sortedPrices = new ArrayList<String>(prices);
		  // sort the list
		  Collections.sort(sortedPrices);
		  System.out.println(sortedPrices);
		  */
	       
	       
	       JavascriptExecutor js = (JavascriptExecutor)driver;
           //To perform scroll operation in upward direction
			js.executeScript("window.scrollBy(0,-500)");
			System.out.println("scroll operation in upward direction");
			
			//navigate to women>> Dresses >> Evening Dresses
			Actions a = new Actions(driver);
			WebElement women = driver.findElement(By.xpath("//a[@class='sf-with-ul']"));
			Thread.sleep(2000);
			WebElement evedress = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
			a.moveToElement(women).build().perform();
			System.out.println("navigate to women");
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", evedress);
			System.out.println("clicked on Evening Dresses");
			
			//Thread.sleep(3000);
			//WebDriverWait w =new WebDriverWait(driver,10);
			
			//Go to Catalog and filter out a dress:
			//Size (M) >> Color (Pink) >> Set Range: $50.00 - $52.28
			
			WebElement size = driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_2']//input[1]"));
			JavascriptExecutor exe = (JavascriptExecutor)driver;
			exe.executeScript("arguments[0].click();", size);
			System.out.println("selected size");
			
			WebElement color = driver.findElement(By.xpath("(//input[@class='color-option  '])[2]"));
			JavascriptExecutor colpink = (JavascriptExecutor)driver;
			colpink.executeScript("arguments[0].click();", color);
			System.out.println("selected color");
			
			js.executeScript("window.scrollBy(0,800)");
	
			
			 WebElement slider = driver.findElement(By.cssSelector("div#layered_price_slider > a:nth-of-type(2)"));
					 //div#layered_price_slider left slider
					 //cssSelector("div#layered_price_slider > a:nth-of-type(1)"));
			 
			 
			   Actions actions = new Actions(driver);
			   actions.clickAndHold(slider);
			   
			   actions.moveToElement(slider, 50, (int) 50.28);
			  
			   //System.out.println("slided");
			   actions.build().perform();
			  
			   System.out.println("slider");
			   //Thread.sleep(3000);
			   
			   
			   
			
			   WebElement more = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
			   more.click();
			   
			   for(int i=1;i<3;i++)
				{
					driver.findElement(By.cssSelector("i.icon-plus")).click();// 3 times
				}
			   
			   WebElement saticdropdown = driver.findElement(By.id("group_1"));
				Select dropdown = new Select(saticdropdown);
				dropdown.selectByVisibleText("M");
				Thread.sleep(3000);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				
				js.executeScript("window.scrollBy(0,500)");
				
				 WebElement prodcolor = driver.findElement(By.id("color_24"));
				 prodcolor.click();
				 
				 WebElement addtocart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
				 addtocart.click();
				 
			
				 
				   
				 
				    String actual;
					String expt = "Pink, M";
					actual=driver.findElement(By.xpath("//span[text()='Printed Dress']/following-sibling::span")).getText();
					System.out.println("Product successfully added to your shopping cart "+actual);
					Assert.assertEquals(actual, expt);
					System.out.println("Test passed");
					
				
					String actualquantity;
					String exptquantity ="3";
					actualquantity = driver.findElement(By.id("layer_cart_product_quantity")).getText();
					System.out.println("quantity successfully added to your shopping cart "+actual);
					Assert.assertEquals(actualquantity, exptquantity);
					System.out.println("Test passed");
					
					String actualtotal;
					String expttotal ="$152.97";
					actualtotal = driver.findElement(By.id("layer_cart_product_price")).getText();
					System.out.println("total successfully added to your shopping cart "+actualtotal);
					Assert.assertEquals(actualtotal,expttotal);
					System.out.println("Test passed");
					
					
					//Verify total cost (total product cost + shipping cost)
					//Total products $152.97
					//Total shipping  $2.00
					//Total $154.97
					
					String totalproductscost = driver.findElement(By.className("ajax_block_products_total")).getText();
					int totalproducts =Integer.parseInt(totalproductscost);//$152.97
					
					
					String totalshippingcost = driver.findElement(By.className("ajax_cart_shipping_cost")).getText();
					int totalshipping=Integer.parseInt( totalshippingcost);//$2.00
					
					
					String count = driver.findElement(By.xpath("(//span[text()='$154.97'])[2]")).getText();
					int sum=Integer.parseInt(count);
					sum=totalproducts+totalshipping;
					System.out.println(sum);
					
				/*	

					String ActualTotal=driver.findElement(By.xpath("//span[text()='$154.97'])[2]")).getText();
					int ActualTotalValue=Integer.parseInt(ActualTotal);
					System.out.println(ActualTotalValue);
					if(ActualTotalValue==sum)//$154.97==$154.97
					{
					System.out.println("Count Matches");
					}
					else
					{
					System.out.println("count fails");
					}
				*/	
          } 
	
	}
		  
	


