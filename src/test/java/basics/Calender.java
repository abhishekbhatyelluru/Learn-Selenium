package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//To select the date 23-April
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		//Scrolling window.....Without this...It will throws the error
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,1100)");


		Thread.sleep(3000);
		

		driver.findElement(By.xpath("//label[contains(text(),\"Date of travel\")]")).click();
		
		while(!driver.findElement(By.cssSelector("span.cur-month")).getText().contains("April"))
		{
			driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
		}
		
		
	    List<WebElement> dates =driver.findElements(By.cssSelector("span.flatpickr-day")); //common css for all dates
	    
	    int count= driver.findElements(By.cssSelector("span.flatpickr-day")).size();
	    
	    for(int i=0;i<count;i++)
	    {
	    	String textdate=driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).getText();
	    	if(textdate.equalsIgnoreCase("23"))
	    	{
	    		driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).click();
	    		break;
	    	}
	    }
		

	}

}
