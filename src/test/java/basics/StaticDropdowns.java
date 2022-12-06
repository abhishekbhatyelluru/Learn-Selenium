package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {

	public static void main(String[] args)
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver","C:\\Abhishek\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement currencyinr=driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		Select dropdownn=new Select(currencyinr);
		dropdownn.selectByIndex(3);
		System.out.println(dropdownn.getFirstSelectedOption().getText());
		dropdownn.selectByVisibleText("AED");
		System.out.println(dropdownn.getFirstSelectedOption().getText());
		dropdownn.selectByValue("INR");  // <option value="INR">INR</option>
		System.out.println(dropdownn.getFirstSelectedOption().getText());
	}

}
