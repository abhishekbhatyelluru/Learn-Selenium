package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver","C:\\Abhishek\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println("Before=" + driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		
		Thread.sleep(2000L);
		
		//To select 5 Adult
//		driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
//		driver.findElement(By.cssSelector("span#hrefIncAdt")).click(); 
//		driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
//		driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
//		driver.findElement(By.cssSelector("span#hrefIncAdt")).click(); 
		//This method can be done....but senior will not accept...So use loops
		
		//or
		
//		int i=1;
//		while(i<5)
//		{
//			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
//			i++;
//		}
		
		//or
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
		}
		
		driver.findElement(By.cssSelector("input#btnclosepaxoption")).click();
	System.out.println("After=" + driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
	
	
	}

}
