package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		
		Actions objj=new Actions(driver);
		
		//coverting character to uppercase
		objj.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		
		//move to specific element
		WebElement move=driver.findElement(By.cssSelector("a#nav-link-accountList"));
		objj.moveToElement(move).build().perform();
		
		//or
		
		//objj.moveToElement(driver.findElement(By.cssSelector("a#nav-link-accountList"))).build().perform();
		
        
	}

}
