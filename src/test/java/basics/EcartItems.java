package basics;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcartItems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	//	driver.findElement(By.xpath("//h4[contains(text(),\"Cucumber - 1 Kg\")]/following-sibling::div[2]/button"));

		//Add 1 item to cart
//		List<WebElement> productss=driver.findElements(By.cssSelector("h4.product-name"));
//		for(int i=0;i<productss.size();i++)
//		{
//			String name=productss.get(i).getText();
//			
//			if(name.contains("Cucumber"))
//			{
//				//click on add to cart
//				driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();
//				break;
//			}
//		}
		
		
		
		
		//If U want to add multiple items to cart then.....
		String[] itemsneeded= {"Carrot","Cucumber","Brocolli"};
		
		
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

}
