//123
//124

package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with; //copy from the net

public class RelativeLocators123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Import this package from the net and paste here...
		//import static org.openqa.selenium.support.locators.RelativeLocator.with;
		
		//	Get the text of the "Name" 
		WebElement nameEditbox = driver.findElement(By.xpath("//input[@name=\"name\"]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		
		WebElement dob=driver.findElement(By.xpath("//label[@for=\"dateofBirth\"]"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();      
		//If it is "flex" element present in html then these relative locators will not work
		
		
		//clicking the checkbox
		WebElement icecreamlabel=driver.findElement(By.xpath("//label[text()=\"Check me out if you Love IceCreams!\"]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamlabel)).click();

		
		WebElement radiobutton= driver.findElement(By.cssSelector("input#inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText());
		
	}

}
