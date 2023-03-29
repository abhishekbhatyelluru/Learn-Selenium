//117

package javastreamslamda;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.util.Strings;



public class Webtablesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Check the items are sorted in the table
		
		//click on the column
	//	driver.findElement(By.cssSelector("th[aria-label*=\"Veg/fruit\"]")).click();
		
		//capture all webelements to list
		List<WebElement> allwebelementlist=driver.findElements(By.xpath("//tr/td[1]"));
		
		
		//capture text of all webelement to a new(original list)
		List<String> original = allwebelementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(original);
		
		//or or or or or 
		
//		List<String> li=new ArrayList<String>();
//		for(int i=0;i<allwebelementlist.size();i++)
//		{
//			
//			String originall=allwebelementlist.get(i).getText();
//			li.add(originall);
//		}
//		System.out.println(li);
		
		
		//Sorting of the list
		List<String> sortedlist= original.stream().sorted().collect(Collectors.toList());
		System.out.println("After sorting=" + sortedlist);
		
		Assert.assertEquals(original, sortedlist);
		//or
		Assert.assertTrue(original.equals(sortedlist));
		
		

	}

}
