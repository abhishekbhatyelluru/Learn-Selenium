//Pagination

package javastreamslamda;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//I need the price of the banana from the table
		
      
        
        
        List<String> price;
		do
        {
			
		 List<WebElement> allwebelementlistinpage=driver.findElements(By.xpath("//tr/td[1]"));
		 
         price= allwebelementlistinpage.stream().filter(s->s.getText().contains("Banana"))
        .map(s->priceveggie(s)).collect(Collectors.toList());
        
        
        price.forEach(s->System.out.println(s));
        
        if(price.size()<1)
        {
        	driver.findElement(By.cssSelector("a[aria-label=\"Next\"]")).click(); //click on next button to search items 
        }
        }while(price.size()<1);
 
     
		
	}

	private static String priceveggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		
		return pricevalue;
	}


	

}
