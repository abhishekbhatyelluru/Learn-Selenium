package pageobjectt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.reuablecomponents;

public class ProductCatelogue extends reuablecomponents {
	
	WebDriver driver;  //local variable
	
	public ProductCatelogue(WebDriver driver)  //constructor-it will execute 1st and same name as classname
	{
		super(driver);
		this.driver=driver; //passing the life of driver to lacal varable driver....
		PageFactory.initElements(driver,this);  //This is for @FindBy
	}
	
	//List<WebElement> allproducts=driver.findElements(By.cssSelector("div.col-lg-4"));
                     //or or or
	
	@FindBy(css="div.col-lg-4")
	List<WebElement> allproducts;       //used only when driver is present means "driver.findelement(By..)"
	
	@FindBy(css=".mb-3")
	WebElement waitproduct;
	
	
	@FindBy(css="div.toast-container")
	WebElement toastwait;
	
	@FindBy(css=".ng-animating")
	WebElement loadwait;
	

	
//	@FindBy(css="button.w-10")     This not possible because driver is not there...."prd.findelement(..)" is the code
//	WebElement addtocartButton;
	
	By addTocartButton=(By.cssSelector("button.w-10"));
	
	
	
	public List<WebElement> getproductdetails()
	{
		waitElementToappear(waitproduct);
		return allproducts;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement prd= getproductdetails().stream().filter(s->s.findElement(By.tagName("b")).getText().contains("ADIDAS ORIGINAL")).findFirst().orElse(null);
	    return prd;
	}
	
	public void addProductToCart(String productname)
	{
		getProductByName(productname).findElement(addTocartButton).click();
		waitElementToappear(toastwait);
		waitElementToDisappear(loadwait);
	}

	


	
}
	

