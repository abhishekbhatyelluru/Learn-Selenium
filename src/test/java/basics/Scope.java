package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.util.Strings;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//counting the links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Count the links present in only the footer section
	    WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
	    System.out.println( footerdriver.findElements(By.tagName("a")).size());
	  
	  //count the links present in only first coloumn of footer section
	    WebElement coloumndriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //we can directly find xpath by using footerdriver
	    System.out.println(coloumndriver.findElements(By.tagName("a")).size());  
	    
	    //or...........difference is driver and footerdriver
//	    WebElement coloumndriver= driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]//tr/td[1]/ul")); //we can directly find xpath by using footerdriver
//	    System.out.println(coloumndriver.findElements(By.tagName("a")).size());  
	    

	    //click on the each link in first coloumn and check if the pages/links are opening
	    for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
	    {
		   coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER); //opening each link in seperate tab
		             		   //or
//		   String clickonlinktab= Keys.chord(Keys.CONTROL,Keys.ENTER);
//		   coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		   
		  
	   }//This for loop opens the all tab
	    
	   Thread.sleep(5000L);
	    
	   //To get the title of each tab opened 
	   Set<String> abc=driver.getWindowHandles();
       Iterator<String> itr=abc.iterator(); //4-windows....The number=4 will be stored
		   
	   while(itr.hasNext())   //hasnext-Whether next window present or Not
	   {                      //it.next-switch/move to next window
			   driver.switchTo().window(itr.next());
			   System.out.println(driver.getTitle());
	   }
		
	   
	   
 }
}


