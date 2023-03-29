package pageobjectt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.reuablecomponents;

public class CheckoutPage extends reuablecomponents{
	
     WebDriver driver;  
	
	public CheckoutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver,this);  
	
	}
	
	
	@FindBy(css="input[placeholder=\"Select Country\"]")
	WebElement selectcountry;
	
	@FindBy(css="section[class*=\"ta-results\"]")
	WebElement taresult;
	
	@FindBy(css="button[class*=\"ta-item\"]:nth-of-type(2)")
	WebElement countryclick;
	

	@FindBy(css="a[class*=\"action__submit\"]")
	WebElement placeOrderClick;
	
	
	
	
	public void countryselect(String countryname) throws InterruptedException
	{
		 Actions aa=new Actions(driver);
	     aa.sendKeys(selectcountry,countryname).build().perform();
	     
	     
	     waitElementToappear(taresult);
	     
	     countryclick.click();
	     
	     Thread.sleep(3000);
	     
	                             
	}
	
	public void placeorderbutton() throws InterruptedException
	{
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(3000);
		//placeOrderClick.click();
		Actions aa=new Actions(driver);
		aa.moveToElement(placeOrderClick).click().build().perform();
		
	}
	

}
