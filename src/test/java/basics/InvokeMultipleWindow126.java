package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindow126 {

	public static void main(String[] args) throws InterruptedException {
	
		
		//Invoking Multiple Windows/Tabs from Selenium using one driver Instance
		
//		Scenario :
//		Navigate to https://rahulshettyacademy.com/angularpractice/
//	    Fill the "Name" field with the first course name available at "https://rahulshettyacademy.com"
		


		
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB); //opening the new blank tab
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentwindowId=it.next();
		String childwindowId=it.next();
		
		driver.switchTo().window(childwindowId);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(3000);
		
	    String fisrtcourseName =driver.findElements(By.cssSelector("a[href*=\'https://courses.rahulshettyacademy.com/p\']")).get(3).getText();
	
	    driver.switchTo().window(parentwindowId);
	    driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys(fisrtcourseName);


	}

}
