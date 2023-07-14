package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
WebDriver driver;

By productnames = By.cssSelector("a.product-name");
By productprices = By.xpath("//div[@class='right-block']/div/span[@class='price product-price']");
By womenlink = By.xpath("//a[@class='sf-with-ul']");
By eveningdresses = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]");
By size = By.xpath("//div[@id='uniform-layered_id_attribute_group_2']//input[1]");
By color = By.xpath("(//input[@class='color-option  '])[2]");
By slider = By.cssSelector("div#layered_price_slider > a:nth-of-type(2)");
By morebtn = By.xpath("//span[contains(text(),'More')]");
//"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[2]/span[1]");
//xpath("//span[contains(text(),'More')]");
//cssSelector("i.icon-plus");
By plusicon = By.cssSelector("i.icon-plus");
//.btn.btn-default.button-plus.product_quantity_up > span");
By sizedropdown = By.xpath("//select[@id='group_1']");
By sizeM = By.xpath("//div[@id='uniform-group_1']/select/option[@title='M']");
By prodcolor = By.id("color_24");
By addtocart = By.xpath("//span[contains(text(),'Add to cart')]");
By colorsize = By.xpath("//span[text()='Printed Dress']/following-sibling::span");
By quantity = By.id("layer_cart_product_quantity");
By total = By.id("layer_cart_product_price");
By productscost = By.xpath("//div[@class='layer_cart_row']/span[@class='ajax_block_products_total']");
By shippingcost = By.xpath("//div[@class='layer_cart_row']/span[@class='ajax_cart_shipping_cost']");
By count = By.xpath("//div[@class='layer_cart_row']/span[@class='ajax_block_cart_total']");
By SecondImg = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]");



public landingPage(WebDriver driver) 
{
	this.driver=driver;
}

public List<WebElement> getProductnames() {
	
    	return driver.findElements(productnames);
    	
    }
	
	
public List<WebElement> getProductprices() {
	return driver.findElements(productprices);
	
}

public WebElement getWomenlink() {
	return driver.findElement(womenlink);
	}
public WebElement geteveningdresses() {
	return driver.findElement(eveningdresses);

}
public WebElement getsize() {
	return driver.findElement(size);
	}
public WebElement getcolor() {
	return driver.findElement(color);
	}
public WebElement getslider() {
	return driver.findElement(slider);
	}
public WebElement getmorebtn() {
	return driver.findElement(morebtn);
	}
public WebElement getplusicon() {
	return driver.findElement(plusicon);
	}
public WebElement getsizedropdown() {
	
return driver.findElement(sizedropdown);
	}
public WebElement getsizeM() {
	return driver.findElement(sizeM);
	}

public WebElement getprodcolor() {
	return driver.findElement(prodcolor);
	}
public WebElement getaddtocart() {
	return driver.findElement(addtocart);
	}
public WebElement getcolorsize() {
	return driver.findElement(colorsize);
	}
public WebElement getquantity() {
	return driver.findElement(quantity);
	}
public WebElement gettotal() {
	return driver.findElement(total);
	}
public WebElement getproductscost() {
	return driver.findElement(productscost);
	}
public WebElement getshippingcost() {
	return driver.findElement(shippingcost);
	}
public WebElement getcount() {
	return driver.findElement(count);
	}
public WebElement getSecondImg() {
	return driver.findElement(SecondImg);
	}
}
