package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrolljavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//To perform scrolling of window
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(3000);
		
		//Scrolling of the table
		jss.executeScript("document.querySelector(\"div.tableFixHead\").scrollTop=5000");
		
		//To count the amount
		List<WebElement> values=driver.findElements(By.xpath("//td[4]"));
		int sum=0;
		for(int i=0;i<values.size();i++)          //Integer.parseint= To convert he string value to int
		{
		     sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
	

	}

}
