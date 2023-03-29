//156

package pageobjectt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.reuablecomponents;

public class LandingPage extends reuablecomponents {
	    
//Standalonetestpageobject refer
	
		WebDriver driver;  //local variable
		
		public LandingPage(WebDriver driver)  //constructor-it will execute 1st and same name as classname
		{
			super(driver);
			this.driver=driver; //passing the life of driver to lacal varable driver....
			PageFactory.initElements(driver,this);  //This is for @FindBy
		}
		
		//driver.findElement(By.id("userEmail")).sendKeys("yiwovo8122@usharer.com");
				//or or or
		
		@FindBy(id="userEmail")   //Page Factory model
		WebElement emailid;
		
		@FindBy(id="userPassword")
		WebElement passwordd;
		
		@FindBy(id="login")
		WebElement submit;
		
		public void landingapplication(String mail,String pass)
		{
			emailid.sendKeys(mail);
			passwordd.sendKeys(pass);
			submit.click();
		}
		
		public void openweb()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		
	
		
		
		
		
		
		




}
