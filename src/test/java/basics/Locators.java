package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators
{

	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Locators obj=new Locators();
		String finalpassword=obj.getpassword(driver);
		System.out.println("Final password=" +finalpassword );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
	//	driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("john");
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("hello123");
		driver.findElement(By.xpath("//form/input[2]")).clear();
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("john@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Phone Number\"]")).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[placeholder*=\"Pass\"]")).sendKeys(finalpassword);
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click(); 
		driver.close();
		
		}
	
	public String getpassword(WebDriver driver) throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordtext=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.  =This is the Text
		String[] arraytext1=passwordtext.split("'");
		//0th index=Please use temporary password 
		//1th index=rahulshettyacademy' to Login.
		String[] arraytext2=arraytext1[1].split("'");
		//0th index=rahulshettyacademy
		//1st index=to Login.
		String password=arraytext2[0];
		System.out.println("Extracted password=" + password);
		return password;
		
		
		
		
	}

}
