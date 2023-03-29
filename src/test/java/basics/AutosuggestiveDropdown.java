package basics;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver","C:\\Abhishek\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		System.out.println(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).click();		
		//Checking whether the checkbox is selected or not
		System.out.println(driver.findElement(By.cssSelector("div[id=\"familyandfriend\"] input[type=\"checkbox\"]")).isSelected());
		//counting the number of checkboxes
		//Select the comon locator in all checkbox...That is "type" in this case
		System.out.println("No of checkbox=" + driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());		
		
		
		//To select current date in calender
		driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click(); //seperate locator will be there for current date
		
		
		//Autosuggestive dropdown
		driver.findElement(By.cssSelector("input#autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
				List<WebElement> optionss=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//driver.findElementsssssss
		for(WebElement option :optionss)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}

	}

}
