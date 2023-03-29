package abstractcomponents;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reuablecomponents 
{
	WebDriver driver;
	public reuablecomponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="button[routerlink*=\"cart\"]")  //cart is common in all page...so it is reusable
	WebElement cartclick;

	public void waitElementToappear(WebElement findby)
	{
	WebDriverWait waitt=new  WebDriverWait(driver,Duration.ofSeconds(5));
    waitt.until(ExpectedConditions.visibilityOf(findby));
    
    }
	public void waitElementToDisappear(WebElement ele)
	{
	WebDriverWait waitt=new  WebDriverWait(driver,Duration.ofSeconds(5));
    waitt.until(ExpectedConditions.visibilityOf(ele));
        
    }
	
	public void waitsometime() throws InterruptedException 
	{
	   //Thread.sleep(3000);
		TimeUnit.SECONDS.sleep(3);
	}
	
	public void cartbutton() throws InterruptedException 
	{      
	
		  // Thread.sleep(2000);
		 TimeUnit.SECONDS.sleep(3);
		   cartclick.click();
		
	}
	
	
	
	
}