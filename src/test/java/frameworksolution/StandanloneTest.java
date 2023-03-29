//149,150,151,152,153

package frameworksolution;

import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;
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
import org.testng.Assert;



public class StandanloneTest {

	
	public static void main(String[] args) throws InterruptedException  {

		//System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		//or
		WebDriverManager.chromedriver().setup();   //we have to add dependency to selenium
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		//email=yiwovo8122@usharer.com
		//password=Asdfghjkl@1234
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("yiwovo8122@usharer.com");
		driver.findElement(By.id("userPassword")).sendKeys("Asdfghjkl@1234");
		driver.findElement(By.id("login")).click();	
		
		Thread.sleep(3000);
		
		
		List<WebElement> allproducts=driver.findElements(By.cssSelector("div.col-lg-4"));
		
//		for(int i=0; i<allproducts.size();i++)
//		{
//			String protext=allproducts.get(i).findElement(By.tagName("b")).getText().trim();
//			System.out.println(protext);
//			
//			if(protext.equalsIgnoreCase("ADIDAS ORIGINAL"))
//			{
//					
//				allproducts.get(i).findElement(By.cssSelector("button.w-10")).click();
//				break;
//			}
//		}
		
	//or or or or or or or
		
	  WebElement prd= allproducts.stream().filter(s->s.findElement(By.tagName("b")).getText().contains("ADIDAS ORIGINAL")).findFirst().orElse(null);
      prd.findElement(By.cssSelector("button.w-10")).click();
      
      //add to cart display messege 
      WebDriverWait waitt=new  WebDriverWait(driver,Duration.ofSeconds(5));
      waitt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.toast-container"))));
      
      //waiting until that load becomes end while add to cart
      waitt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
      
      driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
      
     //checking add to cart item present in cart list
     List<WebElement> cartitems= driver.findElements(By.cssSelector("ul[class*=\"cartWrap\"] h3"));
     boolean match=cartitems.stream().anyMatch(s->s.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));  //returns true if it is equal
     Assert.assertTrue(match);
     
     //checkout
     driver.findElement(By.cssSelector("ul[style=\"list-style-type: none;\"] button")).click();
     
     
     //Select country
     Actions aa=new Actions(driver);
     aa.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")),"India").build().perform();
                             //or or or or
    // driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")).sendKeys("India");
     
     
     waitt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("section[class*=\"ta-results\"]"))));
     
     driver.findElement(By.cssSelector("button[class*=\"ta-item\"]:nth-of-type(2)")).click();
     
    // Thread.sleep(3000);
     TimeUnit.SECONDS.sleep(3);
     
 	JavascriptExecutor jss=(JavascriptExecutor)driver;
	jss.executeScript("window.scrollBy(0,2000)");
     
	//Thread.sleep(3000);
	      //or
	 TimeUnit.SECONDS.sleep(3);
     
     driver.findElement(By.cssSelector("a[class*=\"action__submit\"]")).click();
     
     //Checking the display messege
     String confirmMessege=driver.findElement(By.cssSelector("h1.hero-primary")).getText();
     Assert.assertTrue(confirmMessege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     
     
     
	  
	}
}
		


	

