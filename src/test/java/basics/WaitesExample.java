package basics;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitesExample {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] itemsneeded= {"Carrot","Cucumber","Brocolli"};
		
        additems(driver,itemsneeded);
        applycoupen(driver);
		
	}
	
	
	public static void  additems(WebDriver driver,String[] itemsneeded)
	{
        
        
		//convert the array into list
		List<String> itemlist = Arrays.asList(itemsneeded);
		
		List<WebElement> productss=driver.findElements(By.cssSelector("h4.product-name"));
		
		
		for(int i=0;i<productss.size();i++)
		{
			
			String[] name=productss.get(i).getText().split("-"); //Text will be=Cucumber -1 Kg
			//We don't want that 1 kg...so use split and remove one extra space
			//name[0]=Cucumber    name[1]=1 Kg
			String formattedName=name[0].trim();    //Removing the space
				
			
			int j=0;
			if(itemlist.contains(formattedName))
			{
				j++;
				//click on add to cart
				//driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click(); Once it is clicked....The text will change to "Added". So for next iteration,it will miss match the count...So dont depend on the text locators
				  driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				 
				  if(j==itemsneeded.length) //To skip unnecessary iteration
				  {
					  break;
				  }
				
			}
		}
		
	}
	static void applycoupen(WebDriver driver)
	{
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promobtn")).click();
		//explisit wait
//		WebDriverWait w=new WebDriverWait(driver,5);
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

}
