//155-162

package frameworksolution;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjectt.CheckoutPage;
import pageobjectt.ConfirmationPage;
import pageobjectt.LandingPage;
import pageobjectt.ProductCatelogue;
import pageobjectt.cartpage;

import org.testng.Assert;

import abstractcomponents.reuablecomponents;

public class StandanloneTestpageobject
{

	
	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		//or
	//	WebDriverManager.chromedriver().setup();   //we have to add dependency to selenium
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		
		String name="ADIDAS ORIGINAL";
		LandingPage loginpage=new LandingPage(driver);
		loginpage.openweb();
		loginpage.landingapplication("yiwovo8122@usharer.com","Asdfghjkl@1234");
		
		ProductCatelogue productlist=new ProductCatelogue(driver);
		List<WebElement>list=productlist.getproductdetails();
		productlist.addProductToCart(name);
		
		reuablecomponents reuse=new reuablecomponents(driver);
		reuse.cartbutton();
		
		cartpage pagecart=new cartpage(driver);
		Boolean matchh=pagecart.listsamechecking(name);
		Assert.assertTrue(matchh); //validation is here only
		pagecart.checkoutclick();
		
		CheckoutPage pagecheckout=new CheckoutPage(driver);
		String countryname="India";
		pagecheckout.countryselect(countryname);
		pagecheckout.placeorderbutton();
		
		ConfirmationPage confirmOrderPage=new ConfirmationPage(driver);
		String messege=confirmOrderPage.confirmMesg();
		Assert.assertTrue(messege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
}
		


	

