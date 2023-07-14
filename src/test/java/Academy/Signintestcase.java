package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.loginPage;

public class Signintestcase extends base
{
	public WebDriver driver;
	base b=new base();
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 
	}
	
	@Test(dataProvider="getdata")
	public void baseTestNavigation(String Username,String Password) throws IOException, InterruptedException 
	{
		 driver.get(prop.getProperty("url")); 
		 loginPage l = new  loginPage(driver);
		 l.getsignin().click();
		 l.getemail().sendKeys(Username);
		 l.getpassword().sendKeys(Password);
		 l.getsubmit().click();
		 System.out.println("clicked on login button");
		 
	}
	
	@DataProvider
	public Object[][] getdata() 
	{
	   //row stands for how many different data types test should run
		//column stands for how many values for each test
       Object[][] data = new  Object[1][2];
       //0th row
       data[0][0] = "testautomationmfs@gmail.com";
       data[0][1] = "TestAutomation@123";
       
       return data;
    }
	
	 @AfterTest
	    public void teardown() {
	    	driver.close();
	    }
}

