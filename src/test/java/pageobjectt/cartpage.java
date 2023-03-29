package pageobjectt;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractcomponents.reuablecomponents;

public class cartpage extends reuablecomponents
{
	WebDriver driver;  //local variable
	
	public cartpage(WebDriver driver)  //constructor-it will execute 1st and same name as classname
	{
		super(driver);
		this.driver=driver; //passing the life of driver to lacal varable driver....
		PageFactory.initElements(driver,this);  //This is for @FindBy
	}
	
	
	@FindBy(css="ul[class*=\"cartWrap\"] h3")
	List<WebElement> cartitems;
	
	@FindBy(css="ul[style=\"list-style-type: none;\"] button")
	WebElement checkclick;
	
//	public List<WebElement> confirminglist()
//	{
//		 return cartitems;
//		
//		     
//	}
	public Boolean listsamechecking(String name)
	{
	
		Boolean match=cartitems.stream().anyMatch(s->s.getText().equalsIgnoreCase(name)); 
	   //returns true if it is equal
		
		return match;
	}
	
	public void checkoutclick()
	{
		checkclick.click();
	}

}
