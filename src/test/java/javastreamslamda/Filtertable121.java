//121

package javastreamslamda;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filtertable121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//search in filter and verify in table items are same or not
		driver.findElement(By.cssSelector("input#search-field")).sendKeys("Rice");
		
		  List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

	        //1 results

	       List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).

	        collect(Collectors.toList());

	       //1 result

	       Assert.assertEquals(veggies.size(), filteredList.size());
		

	}

}
