package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		//switching to frame....We can switch by index no,Id,Webelement
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		//or
		
//		counting the number of frames available and switching to the frames by index
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
//		driver.switchTo().frame(0);
		
		//drag and drop using action class
		Actions aa=new Actions(driver);
		driver.findElement(By.id("draggable")).click();
		WebElement sourcee=driver.findElement(By.id("draggable"));
		WebElement targett=driver.findElement(By.id("droppable"));
		aa.dragAndDrop(sourcee,targett).build().perform();
		
		//To exit from the frame
		driver.switchTo().defaultContent();

	}

}
