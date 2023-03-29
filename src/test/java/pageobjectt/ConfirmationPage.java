package pageobjectt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import abstractcomponents.reuablecomponents;

public class ConfirmationPage extends reuablecomponents{
	
WebDriver driver;  
	
	public ConfirmationPage(WebDriver driver)  
	{
		super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver,this); 
	}
	
	
	@FindBy(css="h1.hero-primary")
	WebElement mesg;

	
	public String confirmMesg()
	{
		
	     String confirmMessege=mesg.getText();
	     
	     return confirmMessege;
	     
	}
}
