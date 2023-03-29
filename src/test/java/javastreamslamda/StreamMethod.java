package javastreamslamda;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//I need the price of the rise from the table
		
        List<WebElement> allwebelementlist=driver.findElements(By.xpath("//tr/td[1]"));
        
        List<String> price= allwebelementlist.stream().filter(s->s.getText().contains("Rice"))
        .map(s->priceveggie(s)).collect(Collectors.toList());
        
        System.out.println(price);   //Observe the difference
        price.forEach(s->System.out.println(s));
 
     
		
	}

	private static String priceveggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
