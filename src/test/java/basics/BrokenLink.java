package basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		 //broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        //  Java methods will call URL's and gets you the status code
        //if status code greater than 400 then that url is not working meanslink which tied to url is broken

		
		//Coolecting all link of footersection and cheching for broken links
	   List<WebElement> links=	driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
	   SoftAssert a=new SoftAssert();
	   
	   //Using Enhanced FORLOOP
	   for(WebElement onelink:links)  //one by one item stored in "link" from "links
	   {
		   String url=onelink.getAttribute("href");
		   HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
	    	conn.setRequestMethod("HEAD");
	    	conn.connect();
	    	int rescode=conn.getResponseCode();
	    	System.out.println(rescode);
	    	a.assertTrue(rescode<400,"broken link name is = "+ onelink.getText()+ "and resonse code is" + rescode );

	   }
	   a.assertAll();   //It will report the all errors at end 
	   
	   
	   
	   
	   //Using Normal ForLoop
//	   for(int i=0;i<links.size();i++)
//	   {
//		 String url=  driver.findElements(By.cssSelector("li[class=\"gf-li\"] a")).get(i).getAttribute("href");
//	   	 HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
//	    	conn.setRequestMethod("HEAD");
//	    	conn.connect();
//	    	int rescode=conn.getResponseCode();
//	    	System.out.println(rescode);
//	    	
//	    	a.assertTrue(rescode<400,"broken link name is = "+ driver.findElements(By.cssSelector("li[class=\"gf-li\"] a")).get(i).getText()+ "and resonse code is" + rescode );
//  
//	   
//	   }
//	 
		
		
		//Checking for single URL/Link
//    	String url = driver.findElement(By.cssSelector("a[href*=\"soapui\"]")).getAttribute("href"); //It will return the exact url
//    	
//    	HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
//    	conn.setRequestMethod("HEAD");
//    	conn.connect();
//    	int rescode=conn.getResponseCode();
//    	System.out.println(rescode);
    	
    	
	}

}
