package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;

	
	By signin = By.linkText("Sign in");
	By email = By.id("email");
	By password = By.id("passwd");
	By submit = By.id("SubmitLogin");
	
	
	

	public loginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public WebElement getsignin() 
	{
		return driver.findElement(signin);
	}

	public WebElement getemail()
	{
		
		return driver.findElement(email);
	}
	
	public WebElement getpassword() 
	{
		return driver.findElement(password);
	}
	public WebElement getsubmit() 
	{
		return driver.findElement(submit);
	}
	
	
	
}
