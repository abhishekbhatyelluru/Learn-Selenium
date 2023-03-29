package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).click();		
		//Checking whether the checkbox is selected or not
		System.out.println(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		//counting the number of checkboxes
		//Select the comon locator in all checkbox...That is "type" in this case
		System.out.println("No of checkbox=" + driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());		
		
		
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
		}
		
		driver.findElement(By.cssSelector("input#btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div#divpaxinfo")).getText(), "5 Adult");
	System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
	

	}

	}

