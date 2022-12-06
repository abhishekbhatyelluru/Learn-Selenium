package basics;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name="rahul";
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder*=\"Pass\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(2000);
	//	System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"login-container\"]/h2")).getText(),"Hello "+name+"," );	
		driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click(); //*****//
		
	}

}
